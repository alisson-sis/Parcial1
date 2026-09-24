package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.Hotel;
import co.edu.uniquindio.poo.model.Huesped;
import co.edu.uniquindio.poo.model.Reserva;
import co.edu.uniquindio.poo.model.Reutilizacion;

/*
*Esta clase representa las gestion total del Sistema
*@version 1.0
*@author: Alisson Mariana Gomez Molano
@fecha: 22/09/26
 */
public class Main {

    private static Hotel hotel = new Hotel("StayPlus Hotel",
            "900123456-7", "Calle 10", "6015551234" );


    private static String documentoIdentidad, nombreHuesped, telefono, ciudad, codigo, fechaReserva,
            metodopPago;
    private static byte edad;
    private static int noches, opcion;

    public static void main(String[] args) {
        do {
            mostrarMenu();
            opcion = Reutilizacion.ingresarEntero("Seleccione una opción:");

            switch (opcion) {
                case 1 -> registrarHuesped();
                case 2 -> registrarReserva();
                case 3 -> consultarHuesped();
                case 4 -> hotel.evaluarDisponibilidad();
                case 5 -> hotel.analizarMatriz();
                case 6 -> hotel.obtenerReservaEspecial();
                case 7 -> consultarIngresos();
                case 8 -> Reutilizacion.mostrarMensaje("\n¡Gracias por usar StayPlus!");
                default -> Reutilizacion.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 8);
    }

    private static void mostrarMenu() {
        Reutilizacion.mostrarMensaje("\n MENÚ STAYPLUS");
        Reutilizacion.mostrarMensaje("1. Registrar Huésped | 2. Registrar Reserva | 3. Consultar Huésped");
        Reutilizacion.mostrarMensaje("4. Disponibilidad    | 5. Matriz Ocupación  | 6. Reservas Capicúa");
        Reutilizacion.mostrarMensaje("7. Ingresos por Fecha  | 8. Salir");
    }

    private static void registrarHuesped() {
        Reutilizacion.mostrarMensaje("\n NUEVO HUÉSPED ");
        documentoIdentidad = Reutilizacion.ingresarMensaje("Documento:");
        nombreHuesped = Reutilizacion.ingresarMensaje("Nombre:");
        edad = (byte) Reutilizacion.ingresarEntero("Edad:");
        telefono = Reutilizacion.ingresarMensaje("Teléfono:");
        ciudad = Reutilizacion.ingresarMensaje("Ciudad:");

        hotel.registrarHuesped(new Huesped(documentoIdentidad, nombreHuesped, edad, telefono, ciudad));
        Reutilizacion.mostrarMensaje("¡Huésped registrado exitosamente!");
    }

    private static void registrarReserva() {
        Reutilizacion.mostrarMensaje("\n NUEVA RESERVA ");
        telefono = Reutilizacion.ingresarMensaje("Teléfono del huésped:");
        Huesped nuevoHuesped = hotel.buscarHuesped(telefono);

        if (nuevoHuesped == null) {
            Reutilizacion.mostrarMensaje("Huésped no encontrado. Regístrelo primero.");
            return;
        }

        codigo= Reutilizacion.ingresarMensaje("Código de reserva (ej: 1221):");
        fechaReserva= Reutilizacion.ingresarMensaje("Fecha (YYYY-MM-DD):");
        noches= Reutilizacion.ingresarEntero("Número de noches:");
        metodopPago = Reutilizacion.ingresarMensaje("Método de Pago:");

        hotel.agregarReserva(new Reserva(codigo, fechaReserva, noches, (byte) 1, "Confirmada",
                metodopPago, noches * 150000.0, nuevoHuesped));
        Reutilizacion.mostrarMensaje("¡Reserva creada exitosamente!");
    }

    private static void consultarHuesped() {
        telefono = Reutilizacion.ingresarMensaje("Teléfono a buscar:");
        hotel.consultarHuesped(telefono);
    }

    private static void consultarIngresos() {
        fechaReserva = Reutilizacion.ingresarMensaje("Fecha a consultar (YYYY-MM-DD):");
        hotel.calcularIngresoFecha(fechaReserva);
    }
}




