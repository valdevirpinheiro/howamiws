package br.com.eacsoftware.howamiws.interfaces;

import java.util.List;

import javax.jws.WebService;

import br.com.eacsoftware.howamiws.beans.Registro;

@WebService
public interface AppWS {
    String sayHi(String text);
    
    List<Registro> listaRgistrosDiaModulo(String funcionario);
}

