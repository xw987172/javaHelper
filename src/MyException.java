class MyException extends Exception{

    String message;
    public MyException(String mess){
        message = mess;
    }
    @Override
    public String getMessage(){
        return message;
    }

}
