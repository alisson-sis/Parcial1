package co.edu.uniquindio.poo.model;
import java.util.ArrayList;
/*
*Esta clase representa la información del huesped de un hotel
*@version 1.0
*@author: Alisson Mariana Gomez Molano
@fecha: 22/09/26
 */
public class Huesped {

    private String documentoIdentidad;
    private String nombreHuesped;
    private byte edad;
    private String telefono;
    private String ciudad;

    private ArrayList<Reserva> listReservas;

    public Huesped(String documentoIdentidad, String nombreHuesped, byte edad,
                   String telefono, String ciudad) {

        this.documentoIdentidad = documentoIdentidad;
        this.nombreHuesped = nombreHuesped;
        this.edad = edad;
        this.telefono = telefono;
        this.ciudad = ciudad;

        this.listReservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva nuevaReserva) {

        this.listReservas.add(nuevaReserva);
    }

    @Override
    public String toString() {
        return "Huesped{" +
                "documentoIdentidad='" + documentoIdentidad + '\'' +
                ", nombreHuesped='" + nombreHuesped + '\'' +
                ", edad=" + edad +
                ", telefono='" + telefono + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", listReservas=" + listReservas +
                '}';
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getNombreHuesped() {
        return nombreHuesped;
    }

    public void setNombreHuesped(String nombreHuesped) {
        this.nombreHuesped = nombreHuesped;
    }

    public byte getEdad() {
        return edad;
    }

    public void setEdad(byte edad) {
        this.edad = edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public ArrayList<Reserva> getListReservas() {
        return listReservas;
    }

    public void setListReservas(ArrayList<Reserva> listReservas) {
        this.listReservas = listReservas;
    }

}
