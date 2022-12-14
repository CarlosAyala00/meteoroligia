import java.io.*;
import java.net.*;
/*Añadimos otro comentario*/ 
class UDPCliente {

    public static void main(String a[]) throws Exception {

        // Datos necesario
        String direccionServidor = "127.0.0.1";
        if (a.length > 0) {
            direccionServidor = a[0];
        }
        int puertoServidor = 9876;
        
        try {

            BufferedReader inFromUser =
                    new BufferedReader(new InputStreamReader(System.in));

            DatagramSocket clientSocket = new DatagramSocket();

            InetAddress IPAddress = InetAddress.getByName(direccionServidor);
            System.out.println("Intentando conectar a = " + IPAddress + ":" + puertoServidor +  " via UDP...");

            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
            System.out.print("Favor Ingresar La estacion: ");
            String estacion = inFromUser.readLine();
            System.out.print("Ingrese Ciudad: ");
            String ciudad = inFromUser.readLine();
            System.out.print("Ingrese Porcentaje de humedad: ");
            String porcentaje_humedad = inFromUser.readLine();
            System.out.print("Ingrese temperatura: ");
            String temperatura = inFromUser.readLine();
            System.out.print("Ingrese velocidad del viento:");
            String velocidad= inFromUser.readLine();
            System.out.print("Ingrese fecha:");
            String fecha = inFromUser.readLine();
            System.out.print("Ingrese hora: ");
            String hora = inFromUser.readLine();
            tiempo p = new tiempo(estacion,ciudad,porcentaje_humedad,temperatura,velocidad,fecha,hora);
            
            String datoPaquete = cotizacionJSON.objetoString(p); 
            sendData = datoPaquete.getBytes();

            System.out.println("Enviar " + datoPaquete + " al servidor. ("+ sendData.length + " bytes)");
            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, puertoServidor);

            clientSocket.send(sendPacket);

            DatagramPacket receivePacket =
                    new DatagramPacket(receiveData, receiveData.length);

            System.out.println("Esperamos si viene la respuesta.");

            //Vamos a hacer una llamada BLOQUEANTE entonces establecemos un timeout maximo de espera
            clientSocket.setSoTimeout(10000);

            try {
                // ESPERAMOS LA RESPUESTA, BLOQUENTE
                clientSocket.receive(receivePacket);

                String respuesta = new String(receivePacket.getData());
                cotizacion presp = cotizacionJSON.stringObjeto(respuesta.trim());
                
                InetAddress returnIPAddress = receivePacket.getAddress();
                int port = receivePacket.getPort();

                System.out.println("Respuesta desde =  " + returnIPAddress + ":" + port);
                

            } catch (SocketTimeoutException ste) {

                System.out.println("TimeOut: El paquete udp se asume perdido.");
            }
            clientSocket.close();
        } catch (UnknownHostException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
} 