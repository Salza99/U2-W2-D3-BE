package Davide.U2W2D3BE.exceptions;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String who, long id){
        super(who +" con id: " + id + " non presente nel server");
    }
}
