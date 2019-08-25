package controller;

import java.util.Scanner;

import model.data_structures.IEstructura;
import model.logic.MVCModelo;
import model.logic.Viaje;
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
				System.out.println("--------- \nSe cargaran los datos: ");
				modelo = new MVCModelo(); 
				modelo.cargarDatos();
				System.out.println("Datos cargados");
				System.out.println("Numero de viajes cargados: " + modelo.darNumViajes());
				break;

			case 2:
				System.out.println("--------- \nDar mes(numero) a consultar: ");
				dato = lector.next();
				try
				{
					int temp = Integer.parseInt(dato);
					if(temp >= 1 && temp <= 12)
					{
						mesConsulta = temp;
						System.out.println("Mes guardado");
					}
					else
					{
						System.out.println("Mes invalido");
					}
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
