package magarh.com.securie_service.security;

public interface SecurityParams {
	
	public static final String JWT_HEADER_NAME="Authorization";
	public static final String HEADER_PREFIX= "Bearer ";
	public static final String SECRET = "mondesirtsilouoni@gmail.com";
	public static final long EXPIRATION =10*24*3600*1000;  

}
