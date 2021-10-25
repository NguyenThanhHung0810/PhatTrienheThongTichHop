package ChuHoa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class RequestProcesing extends Thread {
    Socket s;
    public RequestProcesing(Socket socket) {
        s = socket;
    }

    public static class service {
        public static String UpperCaseFirstWord(String string) {
            char[] tempC = string.toLowerCase().toCharArray();
            boolean findSpace = false;
            for (int i = 0; i < tempC.length; i++) {
                if (!findSpace && Character.isLetter(tempC[i])) {
                tempC[i] = Character.toUpperCase(tempC[i]);
                findSpace = true;
                }
                else if (Character.isWhitespace(tempC[i]) || tempC[i] =='\n') { 
                findSpace = false;
                }
            }
            return String.valueOf(tempC);
          }
    }

    public void run() {
        try {
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            DataInputStream dis = new DataInputStream(is);

            String filename;
            String tempS;
            int temp;
            
            while(true) {
                if(s.isClosed()) break;
              
                tempS = "\n1. In hoa toan bo van ban. \n2. In hoa ki tu dau tien cua tung tu. \n3. Thoat";
                dos.writeUTF(tempS);
                temp = is.read();
                System.out.println("Client " + s.getRemoteSocketAddress() + " requests " + temp);
                switch(temp) {
                    // case 1: {
                    //     File dirFile = new File("ChuHoa/Data/");
                    //     String[] files = dirFile.list();
                    //     tempS = "";
                    //     for(String filesS : files) {
                    //         tempS +=filesS + "\n";
                    //     }
                    //     dos.writeUTF("File: \n" + tempS);
                    //     tempS = "Nhập tên file muốn đọc: ";
                    //     dos.writeUTF(tempS);
                    //     filename = dis.readUTF();
                    //     File file = new File("ChuHoa/Data/" + filename);
                    //     System.out.println(file.getAbsolutePath());
                    //     if(file.exists()) {
                    //         Scanner readfile = new Scanner(file);
                    //         tempS = "";
                    //         while(readfile.hasNextLine()) {
                    //             tempS += readfile.nextLine() + "\n";
                    //         }
                    //         readfile.close();
                    //         dos.writeUTF(tempS);
                    //     }
                    //     else {
                    //         System.out.println(s.getRemoteSocketAddress()+ " requested file not found");
                    //         dos.writeUTF("File not found");
                    //     }
                    //     break;
                    // }

                    case 1: {
                        File dirFile = new File("ChuHoa/Data/");
                        String[] files = dirFile.list();
                        tempS = "";
                        for(String filesS : files) {
                            tempS +=filesS + "\n";
                        }
                        dos.writeUTF("File: \n" + tempS);
                        tempS = "Nhap ten file ban muon chuyen thanh chu hoa: ";
                        dos.writeUTF(tempS);
                        filename = dis.readUTF();
                        File file = new File("ChuHoa/Data/" + filename);
                        System.out.println(file.getAbsolutePath());
                        if(file.exists()) {
                            Scanner readfile = new Scanner(file);
                            tempS = "";
                            while(readfile.hasNextLine()) {
                                tempS += readfile.nextLine() + "\n";
                            }
                            readfile.close();
                            String tempSS = tempS.toUpperCase();
                            dos.writeUTF(tempSS);
                        }
                        else {
                            System.out.println(s.getRemoteSocketAddress()+ " requested file not found");
                            dos.writeUTF("File not found");
                        }
                        break;
                    }

                    case 2: {
                        File dirFile = new File("ChuHoa/Data/");
                        String[] files = dirFile.list();
                        tempS = "";
                        for(String filesS : files) {
                            tempS +=filesS + "\n";
                        }
                        dos.writeUTF("File: \n" + tempS);
                        tempS = "Nhap ten file ban can in hoa ky tu dau tien cua moi dong: ";
                        dos.writeUTF(tempS);
                        filename = dis.readUTF();
                        File file = new File("ChuHoa/Data/" + filename);
                        System.out.println(file.getAbsolutePath());
                        if(file.exists()) {
                            Scanner readfile = new Scanner(file);
                            tempS = "";
                            while(readfile.hasNextLine()) {
                                tempS += readfile.nextLine() + "\n";
                            }
                            readfile.close();
                            String tempSS = service.UpperCaseFirstWord(tempS);
                            dos.writeUTF(tempSS);
                        }
                        else {
                            System.out.println(s.getRemoteSocketAddress()+ " requested file not found");
                            dos.writeUTF("File not found");
                        }
                        break;
                    }

                    case 3: {
                        tempS = "Server disconnect...";
                        dos.writeUTF(tempS);
                        System.out.println("Client " + s.getRemoteSocketAddress() + " disconnects");
                        s.close();
                        break;
                    }
                    
                    default : {
                        tempS = "Server disconnect...";
                        dos.writeUTF(tempS);
                        System.out.println("Client " + s.getRemoteSocketAddress() + " disconnects");
                        s.close();
                        break;
                    }
                }
            }
            // is.close();
            os.close();
            dos.close();
            dis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}