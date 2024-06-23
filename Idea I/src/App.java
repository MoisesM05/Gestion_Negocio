import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner leer = new Scanner(System.in);
        boolean continuar = true;
        App metodosApp = new App();
        Negocio metodos = new Negocio(0, 0);

        while(continuar){

            System.out.println("---Elija una opcion---");
            metodosApp.menu();
            int opcion = leer.nextInt();

            switch (opcion) {
                case 1:
                    metodos.añadirCapital();
                    
                    break;
            
                case 2:
                    metodos.comprar();

                    break;
                case 3:
                    metodos.mostrarTodo();

                    break;
            }
        }
    }

    public void menu(){
        System.out.println("______________________________________________________");
        System.out.println("1. Añadir capital");
        System.out.println("2. Comprar");
        System.out.println("3. Mostrar inventario");
    }
}
