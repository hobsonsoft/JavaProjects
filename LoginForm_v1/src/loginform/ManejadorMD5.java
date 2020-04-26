package loginform;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ManejadorMD5 {

	public String encriptaClave(String clave) throws NoSuchAlgorithmException {
		MessageDigest instanciaMD =MessageDigest.getInstance("MD5");
		instanciaMD.update(clave.getBytes());
		byte[] claveBytes=instanciaMD.digest();
		StringBuilder sb = new StringBuilder();
        for(int y=0; y< claveBytes.length ;y++)
        {
            sb.append(Integer.toString((claveBytes[y] & 0xff) + 0x100, 16).substring(1));
        }
        
		return sb.toString();
	}
}
