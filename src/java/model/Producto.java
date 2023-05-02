package model;

import java.util.ArrayList;

public class Producto {
    
    private int id, rating;
    private String title, desciption, imgUrl, type;
    private double price;

    public Producto() {
    }

    public Producto(int id, int rating, String titulo, String desciption, String imgUrl, String type, double price) {
        this.id = id;
        this.rating = rating;
        this.title = titulo;
        this.desciption = desciption;
        this.imgUrl = imgUrl;
        this.type = type;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", rating=" + rating + ", title=" + title + ", desciption=" + desciption + ", imgUrl=" + imgUrl + ", type=" + type + ", price=" + price + '}';
    }
    
    /* CONTINUAR ARREGLANDO ESTO :)
    public static String toCadena(Producto producto) {
        return "Producto{"
                + "\"title\"=" + producto.getTitle() + ", "
                + "desciption=" + producto.getTrailer() + ","
                + " sinopsis=" + producto.getSinopsis() + ", "
                + "fechaEstreno=" + producto.getFechaEstreno() + ", "
                + "duracion=" + producto.getDuracion()
                + ", nVotos=" + producto.getnVotos() + ", sPuntuacion="
                + producto.getnVotos() + ", id=" + producto.getId() + ", precio=" + producto.getPrecio() + '}';
    }

    public static String fromArrayToJson(ArrayList<Pelicula> peliculas) {
        String resp = "[";
        for (Pelicula pelicula : peliculas) {
            resp += "{"
                    + "'titulo':'" + pelicula.getTitulo() + "', "
                    + "'trailer':'" + pelicula.getTrailer() + "',"
                    + " 'sinopsis':'" + pelicula.getSinopsis() + "', "
                    + "'fechaEstreno':" + pelicula.getFechaEstreno() + ", "
                    + "'duracion':" + pelicula.getDuracion()
                    + ", 'nVotos':" + pelicula.getnVotos() + ", 'sPuntuacion':"
                    + pelicula.getnVotos() + ", 'id':" + pelicula.getId() + ", "
                    + "'precio':" + pelicula.getPrecio() + "}";
            resp += ",";
        }
        resp = resp.substring(0, resp.length() - 1);
        resp += "]";
        return resp;
    }

    public static String toArrayJSon(ArrayList<Pelicula> peliculas) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();
        String resp = gson.toJson(peliculas);

        return resp;
    }
    */
}
