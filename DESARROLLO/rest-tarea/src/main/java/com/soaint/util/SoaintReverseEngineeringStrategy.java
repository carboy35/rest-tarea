package com.soaint.util;

import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Objetivo: Clase que customiza la estrategia de ingenieria reversa usada para la generación de entities.
 * Fecha: 14-09-2018
 * @author Alexis Tapia
 * @version 1.0
 */

import org.hibernate.cfg.reveng.DelegatingReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.ReverseEngineeringStrategy;
import org.hibernate.cfg.reveng.TableIdentifier;

public class SoaintReverseEngineeringStrategy extends DelegatingReverseEngineeringStrategy {
	private static final Log LOG = LogFactory.getLog(SoaintReverseEngineeringStrategy.class);
    public SoaintReverseEngineeringStrategy(ReverseEngineeringStrategy delegate) {
        super(delegate);
    }


      

    @Override 

    public Properties getTableIdentifierProperties(TableIdentifier identifier) { 
try {
        Properties properties = super.getTableIdentifierProperties(identifier); 


        return properties; 
}catch(Exception e) {
	
}
return null;
        

    } 
}
