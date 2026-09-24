package co.edu.uniquindio.poo.model;
import java.util.ArrayList;
/*
*Esta clase representa las gestion de reservas
*@version 1.0
*@author: Alisson Mariana Gomez Molano
@fecha: 22/09/26
 */
public class Reserva {
    private String codigo;
    private String fechaReserva;
    private int noches;
    private byte cantidadHuesped;
    private String estadoReserva;
    private String metodoPago;
    private double valorTotal;

    private Huesped listHuesped;
    private ArrayList<Habitacion> listHabitaciones;

    public Reserva(String codigo, String fechaReserva, int noches, byte cantidadHuesped, String estadoReserva,
                   String metodoPago, double valorTotal, Huesped listHuesped) {

        this.codigo = codigo;
        this.fechaReserva = fechaReserva;
        this.noches = noches;
        this.cantidadHuesped = cantidadHuesped;
        this.estadoReserva = estadoReserva;
        this.metodoPago = metodoPago;
        this.valorTotal = valorTotal;
        this.listHuesped = listHuesped;

        this.listHabitaciones = new ArrayList<>();
    }

    public void agregarHabitacion(Habitacion nuevaHabitacion) {

        this.listHabitaciones.add(nuevaHabitacion);
    }
//capicua---
    public boolean esEspecial() {
        if (this.codigo == null || codigo.isEmpty()) {
            return false;
        }
        String codigoInvertido = "";

        for (int i = this.codigo.length() - 1; i >= 0; i--) {
            codigoInvertido = codigoInvertido + this.codigo.charAt(i);
        }

        return this.codigo.equalsIgnoreCase(codigoInvertido);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getNoches() {
        return noches;
    }

    public void setNoches(int noches) {
        this.noches = noches;
    }

    public byte getCantidadHuesped() {
        return cantidadHuesped;
    }

    public void setCantidadHuesped(byte cantidadHuesped) {
        this.cantidadHuesped = cantidadHuesped;
    }

    public String getEstadoReserva() {
        return estadoReserva;
    }

    public void setEstadoReserva(String estadoReserva) {
        this.estadoReserva = estadoReserva;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Huesped getListHuesped() {
        return listHuesped;
    }

    public void setListHuesped(Huesped listHuesped) {
        this.listHuesped = listHuesped;
    }

    public ArrayList<Habitacion> getListHabitaciones() {
        return listHabitaciones;
    }

    public void setListHabitaciones(ArrayList<Habitacion> listHabitaciones) {
        this.listHabitaciones = listHabitaciones;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "codigo='" + codigo + '\'' +
                ", fechaReserva=" + fechaReserva +
                ", noches=" + noches +
                ", cantidadHuesped=" + cantidadHuesped +
                ", estadoReserva='" + estadoReserva + '\'' +
                ", metodoPago='" + metodoPago + '\'' +
                ", valorTotal=" + valorTotal +
                ", listHuesped=" + listHuesped +
                ", listHabitaciones=" + listHabitaciones +
                '}';
    }
}



