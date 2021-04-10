class Words{

    String english = "";
    String spanish = "";
    String french = "";
    String lan = "";

    public Words(String lan,String e, String s, String f){
        english = e;
        spanish = s;
        french = f;
        this.lan = lan;
    }

    public String ID(){
        String toBe = "";
        if(lan.equals("english")){
            toBe = english;
        }if(lan.equals("spanish")){
            toBe = spanish;
        }if(lan.equals("french")){
            toBe = french;
        }
        return toBe;
    }
    public boolean exists(String word){
        boolean exists = false;
        if(word == english){
            exists = true;
        }else if(word == spanish){
            exists = true;
        }else if(word == french){
            exists = true;
        }

        return exists;
    }

    public String translate(String language){
        String returned = "";

        if(language == "english"){
            returned = english;
        }if(language == "spanish"){
            returned = spanish;
        }if(language == "french"){
            returned = french;
        }
        
        return returned;
    }

    public void printWords(){
        System.out.println("("+english+", "+spanish+", "+french+")");
    }
    
}