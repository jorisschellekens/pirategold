/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.quickestquail.io;

import com.js.quickestquail.model.Movie;
import java.io.File;

/**
 *
 * @author joris
 */
public interface IFileHandler {
    
    public Movie process(File f);
    
}
