
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Interface extends Remote{
	
	public String criptografar(String frase) throws RemoteException;
	public String descriptografar(String frase) throws RemoteException;
	public String gerarHash(String frase) throws RemoteException;
	public boolean verificarHash(String codigo, String hash) throws RemoteException;	
}
