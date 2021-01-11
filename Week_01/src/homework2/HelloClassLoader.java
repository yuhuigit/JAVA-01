package homework2;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloClassLoader extends ClassLoader {

    public static void main(String[] args){
        try {
            //get Hello class
            Class clazz = new HelloClassLoader().findClass("Hello");
            //get hello method
            Method method = clazz.getDeclaredMethod("hello");
            //call hello method
            method.invoke(clazz.newInstance());

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name){
        byte[] data = getFileBytes(name,".xlass");
        decode(data);
        return defineClass(name,data,0,data.length);
    }

    private byte[] getFileBytes(String clsName,String suffix) {
        System.out.println(clsName+suffix);
        File file = new File(clsName+suffix);
        byte[] data = new byte[(int)file.length()];
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream(file));
            dis.readFully(data);
            dis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     *
     * decode algorithm
     *
     * 255 minus each byte
     *
     * @param data
     */
    private void decode(byte[] data) {
        for (int i = 0; i < data.length; i++) {
            data[i] = (byte)(255 - data[i]);
        }
    }


}