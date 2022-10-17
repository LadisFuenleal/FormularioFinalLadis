package com.example.mysplash;

import androidx.core.util.PatternsCompat;

import com.example.mysplash.json.MyInfo;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class ActivityDGEST {
    public static final String TAG = "LadisFuenleal";
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();


    public static byte[] createSha1( String text )
    {
        MessageDigest messageDigest = null;
        byte[] bytes = null;
        byte[] bytesResult = null;
        try
        {
            messageDigest = MessageDigest.getInstance("SHA-1");
            bytes = text.getBytes("iso-8859-1");
            messageDigest.update(bytes, 0, bytes.length);
            bytesResult = messageDigest.digest();
            return bytesResult;
        }
        catch (NoSuchAlgorithmException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static String bytesToHex(byte[] bytes)
    {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }


    public static boolean validarEmail(String email){
        boolean fl;
        if(email.isEmpty()){
            fl=false;
        }else{
            if(PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()){
                fl=true;
            }else{
                fl=false;
            }
        }
        return fl;
    }
    public static boolean usuar(List<MyInfo> list, String usu){
        boolean fl = false;
        for(MyInfo informacion : list){
            if(informacion.getUser().equals(usu)){
                fl=true;
            }
        }
        return fl;
    }

    public static void fillInfo(MyInfo info){
        info.setUser(registroActivity.usu);
        String pass = registroActivity.password + registroActivity.usu;
        info.setContrasena(bytesToHex(createSha1(pass)));
        info.setNumero(registroActivity.tel);
        info.setFecha(registroActivity.dat);
        info.setEscuela(registroActivity.chec);
        info.setCorreo(registroActivity.ecor);
        info.setGen(registroActivity.on);
        info.setNotifi(registroActivity.sw);
        info.setFeliz(registroActivity.tog);
        info.setEdad(registroActivity.ed);
    }
    public static void vaciaJson(String json){
        json = null;
    }


    public static void encuentra(String cadena){
        for(MyInfo info: olvidarContraActivity.list){
            if(loginActivity.persona.equals(info.getUser())){
                cadena = "El usuario existe, recuerde la contraseña";
            }else{
                cadena = "El usuario no existe, recuerde todo";
            }
        }
    }

}
