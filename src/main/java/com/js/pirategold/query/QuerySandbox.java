/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.js.pirategold.query;

import com.js.pirategold.model.Movie;
import com.js.pirategold.omdb.CachedOMDB;
import com.js.pirategold.query.AbstractSyntaxTree.AbstractSyntaxTreeNode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.graphstream.graph.Graph;

/**
 *
 * @author joris
 */
public class QuerySandbox {
 
    public static void main(String[] args)
    {
        List<Tokenizer.Token> tokens = Tokenizer.tokenize("(metascore/10)*imdbrating >= 25");
        tokens = Postfix.toPostfix(tokens);
        
        for(int i=0;i<tokens.size();i++)
            System.out.println(i + "\t" + tokens.get(i).type + "\t\t" + tokens.get(i).text);
        
        AbstractSyntaxTreeNode ast = AbstractSyntaxTree.buildAST(tokens);
       
        Movie mov = CachedOMDB.getMovie("tt2294629");
        
        Map<String, Object> vars = new HashMap<>();
        vars.put("genre", mov.getGenre());
        vars.put("country", mov.getCountry());
        vars.put("metascore", mov.getMetaScore());
        vars.put("imdbrating", mov.getImdbRating());
                
        System.out.println(Evaluator.evaluate(ast, vars));
        
        Graph g = ASTVisualizer.buildGraph(ast);
        g.display();
        
    }
}
