package web.socket.sample;

public class Greeting {

    private String content;

    public Greeting() {
    }

    public Greeting(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
    
	public String toString() {
		return "{\"content \":" + content + "\"}\"";
	}

}
