package controller;

import java.util.Scanner;

import model.logic.MVCModelo;
import view.MVCView;

public class Controller {

	/* Instancia del Modelo*/
	private MVCModelo modelo;
	
	/* Instancia de la Vista*/
	private MVCView view;
	
	private int mesConsulta = 0;
	
	private int idOrigen = 0;
	
	/**
	 * Crear la vista y el modelo del proyecto
	 * @param capacidad tamaNo inicial del arreglo
	 */
	public Controller ()
	{
		view = new MVCView();
		modelo = new MVCModelo();
	}
		
	public void run() 
	{
		Scanner lector = new Scanner(System.in);
		boolean fin = false;
		String dato = "";
		String respuesta = "";

		while( !fin ){
			view.printMenu();

			int option = lector.nextInt();
			switch(option){
				case 1:
					System.out.println("--------- \nCrear Arreglo \nDar capacidad inicial del arreglo: ");
				    int capacidad = lector.nextInt();
				    modelo = new MVCModelo(); 
					System.out.println("Arreglo Dinamico creado");
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;

				case 2:
					System.out.println("--------- \nDar mes(numero) a consultar: ");
					dato = lector.next();
					try
					{
						mesConsulta = Integer.parseInt(dato);
						System.out.println("Mes guardado");
					}
					catch(NumberFormatException e)
					{
						System.out.println("Debe ingresar el mes como un numero");
					}
					break;

				case 3:
					System.out.println("--------- \nDar identificador de la zona de origen a consultar: ");
					dato = lector.next();
					try
					{
						idOrigen = Integer.parseInt(dato);
						System.out.println("Identificador guardado");
					}
					catch(NumberFormatException e)
					{
						System.out.println("Identificador invalido");
					}
					break;

				case 4:
					System.out.println("--------- \nDatos de los viajes: ");
					if(mesConsulta == 0)
					{
						System.out.println("No se ha ingresado un mes");
					}
					if(idOrigen == 0)
					{
						System.out.println("No se ha ingresado una zona de origen");
					}
					if(idOrigen >= 0 && mesConsulta >= 0)
					{
						//pendiente
					}
					break;

				case 5: 
					System.out.println("--------- \nEstadisticas de los viajes: ");
					view.printModelo(modelo);
					System.out.println("Numero actual de elementos " + modelo.darTamano() + "\n---------");						
					break;	
					
				case 6: 
					System.out.println("--------- \n Hasta pronto !! \n---------"); 
					lector.close();
					fin = true;
					break;	

				default: 
					System.out.println("--------- \n Opcion Invalida !! \n---------");
					break;
			}
		}
		
	}	
}
