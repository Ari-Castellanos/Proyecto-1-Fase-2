package proyecto1Fase2_LISP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class Archivo {

    public Archivo() {
    }

    /**
     * Metodo para leer archivos de texto, los convierte en listas de strings
     * @param nombreFichero nombre del archivo a leer
     * @return una lista de strig donde cada strig de la lista representa una linea del archivo de texto
     */
    public ArrayList<String> leerArchivo(String nombreFichero){
        ArrayList<String> lista = new ArrayList<String>();
        // Declarar una variable BufferedReader
        BufferedReader br = null;
        try {
            // Crear un objeto BufferedReader al que se le pasa
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(nombreFichero));
            // Leer la primera línea, guardando en un String
            String texto = br.readLine();
            // Repetir mientras no se llegue al final del fichero
            while(texto != null) {
                // agregar la linea leida a la lista
                lista.add(texto);

                // Leer la siguiente línea
                texto = br.readLine();
            }

        }
        // Captura de excepción por fichero no encontrado
        catch (FileNotFoundException ex) {
            System.out.println("Error: Fichero no encontrado");
            ex.printStackTrace();
        }
        // Captura de cualquier otra excepción
        catch(Exception ex) {
            System.out.println("Error de lectura del fichero");
            ex.printStackTrace();
        }
        // Asegurar el cierre del fichero en cualquier caso
        finally {
            try {
                // Cerrar el fichero si se ha podido abrir
                if(br != null) {
                    br.close();
                }
            }
            catch (Exception ex) {
                System.out.println("Error al cerrar el fichero");
                ex.printStackTrace();
            }
        }
        return lista;
    }
}


