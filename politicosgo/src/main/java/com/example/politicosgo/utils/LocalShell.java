package com.example.politicosgo.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Logger;
 
public class LocalShell {
 
    private static final Logger log = Logger.getLogger(LocalShell.class.getName());    
 
    public String executeCommand(final String command) throws IOException {
         
        final ArrayList<String> commands = new ArrayList<String>();
        commands.add("/bin/bash");
        commands.add("-c");
        commands.add(command);
         
        BufferedReader br = null;        
	
	 try {                        
            final ProcessBuilder p = new ProcessBuilder(commands);
            final Process process = p.start();
            final InputStream is = process.getInputStream();
            final InputStreamReader isr = new InputStreamReader(is);
            br = new BufferedReader(isr);
             
            String line;
	    String toReturn = "";            
            if ((line = br.readLine()) != null) {
		toReturn = line;
            }
	
	return toReturn;
        } catch (IOException ioe) {
            log.severe("Erro ao executar comando shell" + ioe.getMessage());
            throw ioe;
        } finally {
            secureClose(br);
        }
    }
     
    private void secureClose(final Closeable resource) {
        try {
            if (resource != null) {
                resource.close();
            }
        } catch (IOException ex) {
            log.severe("Erro = " + ex.getMessage());
        }
    }
     
    public static void main (String[] args) throws IOException {
        final LocalShell shell = new LocalShell();
        shell.executeCommand("ls ~");
    }
}
