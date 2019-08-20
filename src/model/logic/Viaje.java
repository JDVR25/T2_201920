package model.logic;

public class Viaje
{
	private int idZonaOrigen;
	
	private int idZonaDestino;
	
	private int mes;
	
	private double tiempoPromedioViaje;
	
	private double desviacionEstandarTiempo;
	
	private double tiempoGeometricoPromedio;
	
	private double desviacionEstandarTGeometrico;
	
	public Viaje(int sourceID, int dsTID, int month, double travelTime, double travelTimeDeviation,
			double geometricTime, double geometricDeviation)
	{
		idZonaOrigen = sourceID;
		
		idZonaDestino = dsTID;
		
		mes = month;
		
		tiempoPromedioViaje = travelTime;
		
		desviacionEstandarTiempo = travelTimeDeviation;
		
		tiempoGeometricoPromedio = geometricTime;
		
		desviacionEstandarTGeometrico = geometricDeviation;
	}
	
	public int darIDOrigen()
	{
		return idZonaOrigen;
	}
	
	public int darIdDestino()
	{
		return idZonaDestino;
	}
	
	public int darMes()
	{
		return mes;
	}
	
	public double darTiempoViaje()
	{
		return tiempoPromedioViaje;
	}
	
	public double darDesviacionTiempo()
	{
		return desviacionEstandarTiempo;
	}
	
	public double darTiempoGeometrico()
	{
		return tiempoGeometricoPromedio;
	}
	
	public double darDesviacionTGeometrico()
	{
		return desviacionEstandarTGeometrico;
	}
}
