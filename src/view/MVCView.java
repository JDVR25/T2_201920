package view;

import model.logic.MVCModelo;

public class MVCView 
{
	    /**
	     * Metodo constructor
	     */
	    public MVCView()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Cargar los viajes de UBER");
			System.out.println("2. Consultar cluster de viajes mas grande segun hora");
			System.out.println("3. Ingresar identificador de la zona de origen a consultar");
			System.out.println("4. Consultar viajes del mes de consulta que salieron de la zona de origen dada");
			System.out.println("5. Consultar estadisticas");
			System.out.println("6. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(MVCModelo modelo)
		{
			// TODO implementar
		}
}
