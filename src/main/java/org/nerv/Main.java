package org.nerv;

import org.nerv.domain.Barberia;
import org.nerv.repository.impl.JpaBarberiaRepository;
import org.nerv.service.BarberiaService;
import org.nerv.service.impl.BarberiaServiceImpl;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BarberiaService barberiaService = new BarberiaServiceImpl(new JpaBarberiaRepository());

        while (true) {
            System.out.println("\n==== Menú Barbería ====");
            System.out.println("1. Registrar nueva barbería");
            System.out.println("2. Listar todas las barberías");
            System.out.println("3. Buscar barbería por ID");
            System.out.println("4. Modificar una barbería");
            System.out.println("5. Eliminar una barbería");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    registrarBarberia(scanner, barberiaService);
                    break;
                case 2:
                    listarBarberias(barberiaService);
                    break;
                case 3:
                    buscarBarberia(scanner, barberiaService);
                    break;
                case 4:
                    modificarBarberia(scanner, barberiaService);
                    break;
                case 5:
                    eliminarBarberia(scanner, barberiaService);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
            }
        }
    }

    // Método para registrar una nueva barbería
    private static void registrarBarberia(Scanner scanner, BarberiaService barberiaService) {
        System.out.println("\n== Registrar Barbería ==");
        System.out.print("Ingrese el nombre de la barbería: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese la dirección de la barbería: ");
        String direccion = scanner.nextLine();

        Barberia barberia = new Barberia(nombre, direccion);
        barberiaService.registrarBarberia(barberia);
        System.out.println("Barbería registrada con éxito.");
    }

    // Método para listar todas las barberías
    private static void listarBarberias(BarberiaService barberiaService) {
        System.out.println("\n== Listar Barberías ==");
        barberiaService.listarBarberias().forEach(System.out::println);
    }

    // Método para buscar una barbería por ID
    private static void buscarBarberia(Scanner scanner, BarberiaService barberiaService) {
        System.out.println("\n== Buscar Barbería ==");
        System.out.print("Ingrese el ID de la barbería: ");
        Long id = scanner.nextLong();

        Barberia barberia = barberiaService.buscarBarberia(id);
        if (barberia != null) {
            System.out.println(barberia);
        } else {
            System.out.println("No se encontró una barbería con ese ID.");
        }
    }

    // Método para modificar una barbería
    private static void modificarBarberia(Scanner scanner, BarberiaService barberiaService) {
        System.out.println("\n== Modificar Barbería ==");
        System.out.print("Ingrese el ID de la barbería a modificar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consumir el salto de línea

        Barberia barberia = barberiaService.buscarBarberia(id);
        if (barberia != null) {
            System.out.print("Ingrese el nuevo nombre (anterior: " + barberia.getNombre() + "): ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese la nueva dirección (anterior: " + barberia.getDireccion() + "): ");
            String nuevaDireccion = scanner.nextLine();

            barberia.setNombre(nuevoNombre);
            barberia.setDireccion(nuevaDireccion);
            barberiaService.modificarBarberia(barberia);
            System.out.println("Barbería modificada con éxito.");
        } else {
            System.out.println("No se encontró una barbería con ese ID.");
        }
    }

    // Método para eliminar una barbería
    private static void eliminarBarberia(Scanner scanner, BarberiaService barberiaService) {
        System.out.println("\n== Eliminar Barbería ==");
        System.out.print("Ingrese el ID de la barbería a eliminar: ");
        Long id = scanner.nextLong();

        Barberia barberia = barberiaService.buscarBarberia(id);
        if (barberia != null) {
            barberiaService.eliminarBarberia(id);
            System.out.println("Barbería eliminada con éxito.");
        } else {
            System.out.println("No se encontró una barbería con ese ID.");
        }
    }
}
