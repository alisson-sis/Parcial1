package co.edu.uniquindio.poo.model;


/*
*Esta clase representa las gestion de unhotel
*@version 1.0
*@author: Alisson Mariana Gomez Molano
@fecha: 22/09/26
 */
import java.util.ArrayList;
public class Hotel {
    private String nombreComercial;
    private String nit;
    private String direccion;
    private String telefono;

    //estas son las listas que salen de la clase hotel
    private ArrayList<Huesped> listHuespedes;
    private Habitacion[] listHabitaciones;
    private Reserva[] reservas;
    private String[][] matrizOcupacion;


    public Hotel(String nombreComercial, String nit, String direccion,
                 String telefono) {

        this.nombreComercial = nombreComercial;
        this.nit = nit;
        this.direccion = direccion;
        this.telefono = telefono;

        this.listHabitaciones = new Habitacion[0];
        this.reservas =new Reserva[0];
        this.matrizOcupacion = new String[0][0];


        this.listHuespedes = new ArrayList<>();
    }

    public void registrarHuesped(Huesped nuevoHuesped) {

        this.listHuespedes.add(nuevoHuesped);
    }
    public void agregarReserva(Reserva nuevaReserva) {
        if (this.reservas == null || this.reservas.length == 0) {
            this.reservas = new Reserva[]{
                    nuevaReserva };
        } else {
            Reserva[] nuevoArreglo = new Reserva[this.reservas.length + 1];
            for (int i = 0; i < this.reservas.length; i++) {
                nuevoArreglo[i] = this.reservas[i];
            }
            nuevoArreglo[nuevoArreglo.length - 1] = nuevaReserva;
            this.reservas = nuevoArreglo;
        }
    }
    //aqui consulto el huesped por el telefono
    public void consultarHuesped(String telefono) {
        boolean encontrar = false;
        for (Huesped nuevoHuesped : listHuespedes) {
            if (nuevoHuesped.getTelefono().equals(telefono)) {
                System.out.println(nuevoHuesped);
                encontrar = true;
                break;
            }
        }
        if (!encontrar) {
            System.out.println("no fue encontrado el huesped registrado con el numero de telefono");
        }
    }

    // Agrega esto en Hotel.java
    public Huesped buscarHuesped(String telefono) {
        if (listHuespedes != null) {
            for (Huesped nuevoHuesped : listHuespedes) {
                if (nuevoHuesped.getTelefono().equals(telefono)) {
                    return nuevoHuesped; // Retorna el objeto Huesped encontrado
                }
            }
        }
        return null; // Si no lo encuentra
    }
    //aqui verifico la disponibilidad de habitaciones

    public void evaluarDisponibilidad() {
        int disponible = 0; //contador
        int ocupadas = 0; //contador
        int mantenimiento = 0; //contador

        if (listHabitaciones == null || listHabitaciones.length == 0) {
            System.out.println("no hay habitaciones");
            return;
        }
        //asumo primeras posiciones
        Habitacion mayorPrecio = listHabitaciones[0];
        Habitacion menorPrecio = listHabitaciones[0];

        for (Habitacion nuevaHabitacion : listHabitaciones) {
            if (nuevaHabitacion == null) {
                continue;
            }
            if ("disponible".equalsIgnoreCase(nuevaHabitacion.getEstadoActual())) {
                disponible++;
            } else if ("ocupado".equalsIgnoreCase(nuevaHabitacion.getEstadoActual())) {
                ocupadas++;
            } else if ("mantenimiento".equalsIgnoreCase(nuevaHabitacion.getEstadoActual())) {
                mantenimiento++;
            }
            if (nuevaHabitacion.getPrecio() > mayorPrecio.getPrecio()) {
                mayorPrecio = nuevaHabitacion;
            }
            if (nuevaHabitacion.getPrecio() < menorPrecio.getPrecio()) {
                menorPrecio = nuevaHabitacion;
            }
        }
        System.out.println("CONTROL DE DISPONIBILIDAD");
        System.out.println("Disponibles: " + disponible);
        System.out.println("Ocupadas: " + ocupadas);
        System.out.println("En Mantenimiento: " + mantenimiento);
        System.out.println("Habitación con MAYOR precio: " + mayorPrecio.getNumeroHabitacion() +
                " ($" + mayorPrecio.getPrecio() + ")");
        System.out.println("Habitación con MENOR precio: " + menorPrecio.getNumeroHabitacion() +
                " ($" + menorPrecio.getPrecio() + ")");
    }
    //Matriz

    public void analizarMatriz() {
        if (matrizOcupacion == null) {
            System.out.println("no hay registro");
            return;
        }
        //inicializo
        String[] diasSemana = {"Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado", "Domingo"};
        int numHabitaciones = matrizOcupacion.length;
        int numDias = matrizOcupacion[0].length;

        int[] ocupacionDia = new int[numDias]; // contador
        int totalOcupadasSemana = 0;
//ciclo
        for (int i = 0; i < numHabitaciones; i++) {
            for (int j = 0; j < numDias; j++) {
                if ("O".equalsIgnoreCase(matrizOcupacion[i][j])) {
                    ocupacionDia[j]++;
                    totalOcupadasSemana++;
                }
            }
        }

        int maximoOcupadas = ocupacionDia[0];
        int minimoOcupadas = ocupacionDia[0];
        int diaMaxPosicion = 0;
        int diaMinPosicion = 0;

        for (int j = 1; j < numDias; j++) {
            if (ocupacionDia[j] > maximoOcupadas) {
                maximoOcupadas = ocupacionDia[j];
                diaMaxPosicion = j;
            }
            if (ocupacionDia[j] < minimoOcupadas) {
                minimoOcupadas = ocupacionDia[j];
                diaMinPosicion = j;
            }
        }

        System.out.println("MATRIZ DE OCUPACIÓN SEMANAL");
        System.out.println("Día con MAYOR ocupación: " + diasSemana[diaMaxPosicion] +
                " (" + maximoOcupadas + " habitaciones)");
        System.out.println("Día con MENOR ocupación: " + diasSemana[diaMinPosicion] +
                " (" + minimoOcupadas + " habitaciones)");
        System.out.println("Total habitaciones ocupadas en la semana: " + totalOcupadasSemana);
    }

    //capicua
    public void obtenerReservaEspecial() {
        System.out.println("RESERVAS ESPECIALES (CÓDIGO CAPICÚA)");

        boolean hayEspeciales = false;

        for (Reserva nuevaReserva : reservas) {
            if (nuevaReserva != null && nuevaReserva.esEspecial()) {
                System.out.println("¡SI Hay Reserva Especial! Código: " +
                        nuevaReserva.getCodigo() + "Cliente: " +
                        nuevaReserva.getListHuesped().getNombreHuesped());
                hayEspeciales = true;
            }
        }
        if (!hayEspeciales) {
            System.out.println("No hay reservas con código capicúa.");
        }
    }

    //fecha
    public void calcularIngresoFecha(String fechaConsulta) {
        double ingresoTotal = 0;
        int cantidadReservas = 0;

        for (Reserva nuevaReserva : reservas) {
            if (nuevaReserva != null && nuevaReserva.getFechaReserva().equals(fechaConsulta)) {
                ingresoTotal += nuevaReserva.getValorTotal();
                cantidadReservas++;
            }
        }
        System.out.println("Ingresos para la fecha " + fechaConsulta + ": $" + ingresoTotal +
                " (" + cantidadReservas + " reservas)");
    }
    }


