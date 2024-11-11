import java.util.Scanner;

public class mani{
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);
        int a,afact = 1,b,bfact = 1,d,dfact = 1,c;

        // c=a!/(a-b)! * b!

        System.out.print("Ingrese el primer valor: ");
        a = s.nextInt();
        System.out.print("Ingrese el segundo valor: ");
        b = s.nextInt();

        if(a > 0 && b > 0){
            d = a - b;
            System.out.println("d= " + d);
            for(int i=a; i>1; i--){
                afact = afact * i;
                System.out.println("afact= "+ afact);
            }
            for(int i=b; i>1; i--){
                bfact = bfact * i;
                System.out.println("bfact= "+bfact);
            }
            for(int i=d; i>1; i--){
                dfact = dfact * i;
                System.out.println("dfact= "+dfact);
            }
            
        } else {
            System.out.println("los digitos deben ser mayor a 0");
        }

        c = afact /((dfact)*bfact);
        System.out.println("Hay: " + c + " posibles combinaciones");
    }
}