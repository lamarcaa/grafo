package ExemploGrafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GrafoExercicio {
    
    static class Vertice {
        String nome;
        Map<Vertice, Aresta> adj;
        Vertice(String nome) {
            this.nome = nome;
            this.adj = new HashMap<>();
        }
        void addAdj(Aresta e, Vertice v) {
            adj.put(v, e);
        }
    }
    
    static class Aresta {
        Vertice origem;
        Vertice destino;
        Aresta(Vertice origem, Vertice destino) {
            this.origem = origem;
            this.destino = destino;
        }
    }
    
    Map<String, Vertice> vertices;
    List<Aresta> arestas;
    
    public GrafoExercicio() {
        vertices = new HashMap<>();
        arestas = new ArrayList<>();
    }
    
    Vertice addVertice(String nome) {
        Vertice v = new Vertice(nome);
        vertices.put(nome, v);
        return v;
    }
    
    Aresta addAresta(Vertice origem, Vertice destino) {
        Aresta e = new Aresta(origem, destino);
        origem.addAdj(e, destino);
        arestas.add(e);
        return e;
    }
    
    public String toString() {
        String r = "";
        for (Vertice u : vertices.values()) {
            r += u.nome + " -> ";
            for (Vertice v : u.adj.keySet()) {
                r += v.nome + ", ";
            }
            r += "\n";
        }
        return r;
    }
    
    public boolean adjacente(Vertice u, Vertice v) {
        return u.adj.containsKey(v);
    }
    
    public List<Vertice> vizinhos(Vertice x) {
        List<Vertice> vizinhos = new ArrayList<>();
        for (Vertice v : x.adj.keySet()) {
            vizinhos.add(v);
        }
        return vizinhos;
    }
    
    public void add_vertex(Vertice v) {
        if (!vertices.containsKey(v.nome)) {
            vertices.put(v.nome, v);
        }
    }
    
    public void remove_vertex(Vertice x) {
        if (vertices.containsKey(x.nome)) {
            for (Vertice v : x.adj.keySet()) {
                Aresta e = x.adj.get(v);
                arestas.remove(e);
                v.adj.remove(x);
            }
            vertices.remove(x.nome);
        }
        System.out.println("Vertice " + '(' + x.nome + ')' + " Removido \n");
    }
    
    public String get_vertex_value(Vertice x) {
        return x.nome;
    }
    
    public static void main(String[] args) {
        GrafoExercicio g = new GrafoExercicio();
        Vertice s = g.addVertice("s");
        Vertice t = g.addVertice("t");
        Vertice y = g.addVertice("y");
        Aresta st = g.addAresta(s, t);
        Aresta sy = g.add
		Aresta(s, y);
		Aresta ty = g.addAresta(t, y);
		System.out.println(g);
		g.remove_vertex(t);
		System.out.println(g);
	}
}