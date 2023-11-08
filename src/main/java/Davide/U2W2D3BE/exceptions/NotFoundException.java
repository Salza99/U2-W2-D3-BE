package Davide.U2W2D3BE.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(long id){
        super("blogPost con id: " + id + " non presente nel server");
    }
}
