import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class manivec {
    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int a, afact = 1, b, bfact = 1, d, dfact = 1, c;

        // c = a! / (a-b)! * b!

        System.out.print("Ingrese el primer valor (a): ");
        a = s.nextInt();
        System.out.print("Ingrese el segundo valor (b): ");
        b = s.nextInt();

        if (a > 0 && b > 0 && a >= b) {  // Verificar que a y b sean válidos
            d = a - b;
            System.out.println("d = " + d);

            // Calcular los factoriales
            for (int i = a; i > 1; i--) {
                afact = afact * i;
            }
            for (int i = b; i > 1; i--) {
                bfact = bfact * i;
            }
            for (int i = d; i > 1; i--) {
                dfact = dfact * i;
            }

            // Calcular el número total de combinaciones
            c = afact / (dfact * bfact);
            System.out.println("Hay: " + c + " posibles combinaciones");

            // Mostrar las combinaciones
            List<List<Integer>> combinaciones = generarCombinaciones(a, b);
            System.out.println("Las combinaciones posibles son:");
            for (List<Integer> combinacion : combinaciones) {
                System.out.println(combinacion);
            }
        } else {
            System.out.println("Los valores deben ser mayores a 0 y a debe ser mayor o igual que b.");
        }
    }

    // Método para generar las combinaciones
    public static List<List<Integer>> generarCombinaciones(int a, int b) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> elementos = new ArrayList<>();
        
        // Llenar la lista con los números del 1 al 'a'
        for (int i = 1; i <= a; i++) {
            elementos.add(i);
        }

        // Generar las combinaciones
        combinarRecursivo(elementos, b, 0, new ArrayList<Integer>(), result);

        return result;
    }

    // Función recursiva para generar las combinaciones
    public static void combinarRecursivo(List<Integer> elementos, int b, int index,
                                         List<Integer> combinacion, List<List<Integer>> result) {
        // Cuando la combinación tenga tamaño 'b', la agregamos al resultado
        if (combinacion.size() == b) {
            result.add(new ArrayList<>(combinacion));
            return;
        }

        // Recursivamente agregar elementos a la combinación
        for (int i = index; i < elementos.size(); i++) {
            combinacion.add(elementos.get(i));
            combinarRecursivo(elementos, b, i + 1, combinacion, result);
            combinacion.remove(combinacion.size() - 1);  // Retrocedemos (backtracking)
        }
    }
}
