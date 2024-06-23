import java.util.ArrayList;
import java.util.Scanner;

public class Negocio {
    private int saldo;
    private int totalventas;

    public static Scanner leer = new Scanner(System.in);
    ArrayList <Producto> listProductos = new ArrayList<>();

    public Negocio(int saldo, int totalventas) {
        this.saldo = saldo;
        this.totalventas = totalventas;
    }

    public int getSaldo() {
        return saldo;
    }
    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }
    public int getTotalventas() {
        return totalventas;
    }
    public void setTotalventas(int totalventas) {
        this.totalventas = totalventas;
    }

    //Metodo CAPITAL
    public void añadirCapital(){
        System.out.println("______________________________________________________");
        System.out.println("Capital Total -------- "+saldo);
        System.out.println("Añadir aportes: ");
        saldo += leer.nextInt();
        System.out.println("______________________________________________________\n");
        leer.nextLine();//Buffer
    }

    public void comprar(){
        System.out.println("______________________________________________________\n");
        System.out.println("--COMPRAR--");
        System.out.println("Saldo actual: "+saldo);
        System.out.println("Nombre del producto: ");
        String nombre = leer.nextLine();
        System.out.println("ID: ");
        String id = leer.nextLine();
        System.out.println("Descripcion: ");
        String descripcion = leer.nextLine();
        System.out.println("Precio por unidad: ");
        int precio = leer.nextInt();
        System.out.println("Cantidad unidad/LBs: ");
        int stock = leer.nextInt();
        System.out.println("______________________________________________________\n");
        leer.nextLine();//Buffer

        System.out.println("Producto: "+nombre+" unidades: "+stock+" precio: "+precio);
        int precioTotal = precio * stock;//Se multiplica las unidades compradas
        System.out.println("Precio total de la compra: "+precioTotal);
        System.out.println("Saldo disponible----------"+saldo);
        System.out.println("______________________________________________________\n");

        boolean continuar = true;
        while(continuar){//CICLOOO

            System.out.println("1. Añadir al carrito xD");//COnfirmacion
            System.out.println("2. Salir al menu principal");
            int confirmar = leer.nextInt();

        if(confirmar > 0 && confirmar <2){//Opcion #1

            if(saldo < precio){//Condicion anidada
                System.out.println("Saldo insuficiente para realizar esta compra!");
                System.out.println("______________________________________________________\n");
                
            }else{
    
                saldo = saldo-precioTotal;//Se le resta la cantidad total por los productos comprados
                listProductos.add(new Producto(nombre, id, descripcion, stock, precio));//Se añade el produ. al inventario
                System.out.println("Compra exitosa!");
                System.out.println("Saldo actual----------"+saldo);
                System.out.println("______________________________________________________\n");
                continuar = false;
            }

        }else if(confirmar > 1 && confirmar < 3){//Opcion #2

            System.out.println("Saliendo al menu principal.....");
            System.out.println("______________________________________________________\n");
            continuar = false;

        }else{

            System.out.println("Ingrese una opcion valida!");
            System.out.println("______________________________________________________\n");
        }


        }
        
        leer.nextLine();//Buffer saliendo del metodo
    }

    public void mostrarTodo(){
        int cont = 1;
        boolean continuar2 = true;

        System.out.println("______________________________________________________\n");
        System.out.println("--- PRODUCTOS EN INVENTARIO ---");
        for(Producto i: listProductos){
            System.out.println(cont+". Nombre ----- "+i.nombre+" Unidades Disponibles ----- "+i.getStock());
            //System.out.println("______________________________________________________\n");
            cont += 1;
        }

        while(continuar2){//CICLOOOOOOO

            System.out.println("______________________________________________________\n");
            System.out.println("1. Seleccionar o buscar");
            System.out.println("2. Salir");
            int selec = leer.nextInt();
            System.out.println("______________________________________________________\n");

            leer.nextLine();//Buffer

        if(selec > 0 && selec < 2){//Opcion #1

            System.out.println("--- Escriba el nombre o codigo del producto ---");
            String buscar = leer.nextLine();

            for(Producto j: listProductos){//Recorriendo la lista para encontrar considencias
                if(buscar.equalsIgnoreCase(j.nombre) || buscar.equalsIgnoreCase(j.getId())){

                    System.out.println("Producto ----- "+j.nombre);
                    System.out.println("ID ----- "+j.getId());
                    System.out.println("Descripcion: "+j.getDescripcion());
                    System.out.println("Precio ----- "+j.getPrecio());
                    System.out.println("Unidades disponibles --- "+j.getStock());
                    System.out.println("______________________________________________________\n");  
                    
                    //Metodo vender
                    boolean salida = true;
                    while (salida) {

                        System.out.println("1. Vender este producto");
                        System.out.println("2. SALIR");
                        int selecion = leer.nextInt();

                    if(selecion > 0 && selecion < 2){//VENDER SELECCION

                        System.out.println("--- VENDER ---");
                        System.out.println("1. Vender unidad");
                        System.out.println("2. Seleccionar cantidad a vender");
                        System.out.println("3. Salir");
                        int selecc2 = leer.nextInt();
            
            
                    if(selecc2 > 0 && selecc2 < 2){//Opcion #1 de venta
            
                        j.setStock(j.getStock()-1);//Le resta -1 a la cantidad de productos disponibles
                        saldo = saldo + j.getPrecio();//Añade el precio al saldo del producto vendido
                        System.out.println("Venta exitosa!");
            
                    }else if(selecc2 > 1 && selecc2 <3){//Opcion #2 de venta
            
                        System.out.println("¿Cuantas unidades de este produ. desea vender?");
                            int cantidad = leer.nextInt();
            
                        if(cantidad > 0 && cantidad <= j.getStock()){
            
                            j.setStock(j.getStock()-cantidad);//Le resta la cantidad a los productos disponibles en inventario.
                            saldo = saldo + (cantidad * j.getPrecio());//Añade el precio total de todos los articulos al capital
                            totalventas += saldo;//MODIFICAR ESTOOOO
                            System.out.println("Venta realizada exitosamente");
                            
                        }else{
            
                            System.out.println("Articulos insuficientes!!");
                        }
                    }else if(selecc2 > 2 && selecc2 < 4){
            
                        System.out.println("Saliendo al menu...");
                        
                    }else{
            
                        System.out.println("Ingrese una opcion valida!");
                    }

                        
                        salida = false;
                    }else if(selecion > 1 && selecion < 3){//Sale del menu donde muestra el inventario

                        System.out.println("Saliendo...");
                        salida = false;
                    }else{

                        System.out.println("Ingrese una opcion valida!");
                    }
                    }
                    
                }

            }

        }else if(selec > 1 && selec < 3){//Opcion #2

            System.out.println("Saliendo al menu principal...");
            System.out.println("______________________________________________________\n");
            continuar2 = false;

        }else{

            System.out.println("Ingrese una opcion valida!");
            System.out.println("______________________________________________________\n");
        }

        }
        
    }

}
