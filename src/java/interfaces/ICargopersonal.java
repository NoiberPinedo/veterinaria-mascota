/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entidades.Cargopersonal;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public interface ICargopersonal {
      public abstract boolean guardarCargopersonal(Cargopersonal cargopersonal);

    public abstract ArrayList<Cargopersonal> listarCargopersonal();

    public abstract boolean ActualizarCargoPersonal(Cargopersonal cargopersonal);

    public abstract boolean eliminarCargoPersonal(Cargopersonal cargopersonal);
}
