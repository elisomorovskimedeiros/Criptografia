import java.rmi.Naming;
import java.rmi.RemoteException;

public class MainServidor {

	public static void main(String[] args)  throws RemoteException{
		
		System.setProperty("java.rmi.server.hostname", "10.132.84.7");
		Interface frase = new Servidor();
		
		try{
			Naming.rebind("frase", frase);
			System.out.println("Servidor Rodando");
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
		/*
		Servidor servidor = new Servidor();
		String teste = "Estou enviando essa mensagem para testar o método de criptografia!!";
		
		System.out.println(teste);
		
		
		//enviei a frase para criptografia
		String retorno = servidor.criptografar(teste);
		
		System.out.println(retorno);
		
		
		//gerei o codigo hash
		String hash = servidor.gerarHash(teste);
		
		//System.out.println(hash);
		
		teste = servidor.descriptografar(retorno);
		
		
		//descriptografei
		System.out.println(teste);
		*/
		

	}

}

