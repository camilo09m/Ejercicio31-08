import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ingresarLimites();
    }
    public static void ingresarLimites() {
        Scanner tecla = new Scanner(System.in);
        int aux = 0;
        do{
            try {
            System.out.println("ingrese el limite inferior de su arreglo");
            int valorInf = tecla.nextInt();
            System.out.println("ingrese el limite superior de su arreglo");
            int valorSupe = tecla.nextInt();
            if (validarEntrada(valorInf,valorSupe)){
                System.out.printf("valor ingresado correctamente");
                aux = 0;
                opcionMenu(generarArreglo(valorInf,valorSupe));
            }
            else {
                System.out.println("El valor ingresado no es correcto");
                aux = 1;
            }
        } catch (Exception e) {
            tecla.next();
            System.err.println("El valor ingresado no es valido intentelo nuevamente");
            aux = 1;
        }
        }while(aux == 1);
    }
    public static boolean validarEntrada(int limInf, int limSup){
        if(limInf>=0&&limSup>=0 && limInf< limSup){
            return true;
        }
    return false;
    }
    public static int[] generarArreglo (int limInf, int limSup){
        int n = limSup - limInf;
        int[] arrNum = new int[n+1];
        arrNum[0]=limInf;
        arrNum[n]=limSup;
        int aux = limInf+1;
        for (int i = 1; i<n;i++){
            arrNum[i]=aux;
            aux=aux+1;
        }
        return arrNum;
    }
    public static boolean validarPrimo (int valor){//le ingresamos un valor el cual se analizará si es primo o no
            int divisor = 2;
            if(valor==0){
                return false;
            }
            while (divisor<valor){
                if (valor%divisor==0){
                    return false;     //se retorna falso en caso de no ser primo
                }
            divisor++;
            }
        return true;  //se retorna verdadero en caso de ser primo
    }
    public static void numPrimos(int[] arrNum){ //en esta funcion almacenaremos los primos en un arreglo cualquiera
        int[] arrprimo = new int[arrNum.length];
        int cont = 0;
        for (int i =0;i<arrNum.length;i++){
            if (validarPrimo(arrNum[i])){//si el numero es primo se almacena en un arreglo el cual tiene el mismo largo que el arreglo de numeros seguidos
                arrprimo[cont]=arrNum[i];
                cont++;//se utiliza el contador para identificar la posicion en la cual guardar el arreglo.
            }
        }
        int[] primos = new int[cont];
        primos=generarArregloPri(arrprimo,cont);
        mostrarArreglo(primos);
    }
    public static int[] generarArregloPri(int[] arrPrimo, int cont){                //recibe el arreglo de numeros primos el cual está con varias casillas sin completar, por lo cual se pasarán los digitos a una adecuada.
        int[] primos = new int[cont];
        for (int i = 0; i<cont;i++) {
            primos[i] = arrPrimo[i];
        }
    return primos;
    }
    public static boolean validarPar(int valor){//se ingresa un valor y se divide en 2 su el resto es igual a cero, entonces retorna un true, de no ser asi retorna un false
        int divisor =2;
        if(valor==0){
            return false;
        }
        if(valor%divisor==0){
            return true;
        }
        return false;
    }
    public static void numPar(int[] arrnum){ //se almacenará los numeros pares en un arreglo incompleto
        int[] arrpar = new int[arrnum.length];
        int cont =0;
        for (int i = 0;i<arrnum.length;i++){
            if (validarPar(arrnum[i])){
                arrpar[cont]=arrnum[i];
                cont++;
            }
        }
        int[] par = new int[cont];
        par=generarArregloPar(arrpar,cont);
        mostrarArreglo(par);
    }
    public static void numImpar(int[] arrnum){
        int[] arrImpar = new int[arrnum.length];
        int cont =0;
        for (int i = 0;i<arrnum.length;i++){
            if (validarPar(arrnum[i])==false){// para almacenar los valores impares se requiere que la validacion sea falsa
                arrImpar[cont]=arrnum[i];
                cont++;
            }
        }

        int[] impar = new int[cont];
        impar=generarArregloPar(arrImpar,cont);
        mostrarArreglo(impar);
    }
    public static int[] generarArregloPar(int[] arrPar, int cont){//se creará un nuevo arreglo con los digitos pares
        int[] par = new int[cont];
        for (int i =0; i<par.length;i++){
            par[i]=arrPar[i];
        }
    return par;
    }
    public static int[] generarArregloImpar(int[] arrImpar, int cont){//se creará un nuevo arreglo con los digitos pares
        int[] impar = new int[cont];
        for (int i =0; i<impar.length;i++){
            impar[i]=arrImpar[i];
        }
    return impar;
    }
    public static void mostrarMenu(){
        System.out.println("Ingrese una opción:");
        System.out.println("[1] Mostrar conjunto.");
        System.out.println("[2] Mostrar numeros pares e impares.");
        System.out.println("[3] Mostrar numeros primos.");
        System.out.println("[4] Cambiar limites del conjunto");
        System.out.println("[0] Salir");
    }
    public static void opcionMenu(int[] arrNum){
        Scanner tecla = new Scanner(System.in);
        int aux=0;
        while (aux==0) {

            mostrarMenu();
            String opcion = tecla.next();
            switch (opcion) {
                case "1":
                    mostrarArreglo(arrNum);
                    break;
                case "2":
                    numPar(arrNum);
                    numImpar(arrNum);
                    break;
                case "3":
                    numPrimos(arrNum);
                    break;
                case "4":
                    ingresarLimites();
                    break;
                case "0":
                    aux=1;
                    break;
                default:
                    System.err.println("opcion ingresada no valida");
            }
        }
    }
    public static void mostrarArreglo(int[] arrNum){
        System.out.println(Arrays.toString(arrNum));
    }
}
