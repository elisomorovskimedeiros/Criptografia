import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


public class Servidor extends UnicastRemoteObject implements Interface{
	
	

	public String frase;
	
	public String codigo;
	
	
	public Servidor() throws RemoteException{}

	@Override
	public String criptografar(String frase) throws RemoteException {
		  
        byte[] bytes = frase.getBytes();  
        String[] binarios = new String[bytes.length];
        String retorno = "";
   
        //System.out.println(frase);  
   
        // jogando prum array de string  
        for (int i=0; i < bytes.length; i++) {  
            binarios[i] = Integer.toBinaryString(bytes[i]);  
            //System.out.println(bytes[i] + " -> " + binarios[i]);
            retorno += binarios[i];
            retorno += " ";
        }  
        return retorno;
	}

	@Override
	public String descriptografar(String frase) throws RemoteException {		
		byte[] bytes = frase.getBytes();  
		String[] binarios = new String[bytes.length];
		StringBuffer texto2 = new StringBuffer();  
        String[] retornos = new String[frase.length()];
        retornos = frase.split(" ");
         
        for (int i=0; i < binarios.length; i++) {  
        	
            texto2.append((char)Integer.parseInt(retornos[i],2));  
        }  
        System.out.println(texto2.toString());
        System.out.println(frase);
		
		return (texto2.toString());
		
		/*
		String[] frases = frase.split(" ");
		
		StringBuffer buffer =  new StringBuffer();
		
		for(int i = 0; i < frases.length; i++){
			buffer.append((char)Integer.parseInt(frases[i],2));
		}
		
		//System.out.println(buffer.toString());
		return (buffer.toString());
		*/
		//return frase;
		
		
		
	}

	@Override
	public String gerarHash(String frase) throws RemoteException {
		try{            
            int hash = frase.hashCode();
            codigo = Integer.toString(hash, Character.MAX_RADIX);
        }catch(Exception e){
            e.printStackTrace();
        }   
        return codigo;
	}

	@Override
	public boolean verificarHash(String codigo, String hash) throws RemoteException {
		codigo = gerarHash(codigo);
		if (codigo.equals(hash))
			return true;
		else
			return false;		
	} 
}

