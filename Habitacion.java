package co.edu.uniquindio.poo.model;
/*
*Esta clase representa la información de la habitación
*@version 1.0
*@author: Alisson Mariana Gomez Molano
@fecha: 22/09/26
 */
public class Habitacion {
    private String numeroHabitacion;
    private String tipoHabitacion;
    private byte piso;
    private int capacidadMaxima;
    private double precio;
    private String estadoActual;

    public Habitacion(String numeroHabitacion, String tipoHabitacion,
                      byte piso, int capacidadMaxima, double precio, String estadoActual){

        this.numeroHabitacion=numeroHabitacion;
        this.tipoHabitacion=tipoHabitacion;
        this.piso=piso;
        this.capacidadMaxima=capacidadMaxima;
        this.precio=precio;
        this.estadoActual=estadoActual;

    }
    public String getNumeroHabitacion() {
        return numeroHabitacion;
    }

    public void setNumeroHabitacion(String numeroHabitacion) {
        this.numeroHabitacion = numeroHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public byte getPiso() {
        return piso;
    }

    public void setPiso(byte piso) {
        this.piso = piso;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getEstadoActual() {
        return estadoActual;
    }

    public void setEstadoActual(String estadoActual) {
        this.estadoActual = estadoActual;
    }

}
