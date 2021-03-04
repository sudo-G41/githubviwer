package com.sutjjang;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Hello world!
 * token : ccdb2b758c9907c911eba26ffbd889343c42b633
 */
public class App 
{
	private static String convertStreamToString(InputStream is)
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try
        {
            while ((line = reader.readLine()) != null)
            {
                sb.append(line + "\n");
            }
        }
        catch (IOException e)
        {
			System.out.print("app.java 29 :");
            e.printStackTrace();
        }
        finally
        {
            try
            {
                is.close();
            }
            catch (IOException e)
            {
				System.out.print("app.java 39 :");
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );
		query q = new query("sudo-G41");
		// System.out.println(q.getToQuery());
		
		// GithubConnection c = new GithubConnection("https://api.github.com/graphql", "ccdb2b758c9907c911eba26ffbd889343c42b633");
		GithubConnection c = new GithubConnection();
		
		OutputStream os = null;
		InputStream is = null;
		String result = null;
		
		// System.out.println(c.getCurl().getClass());
		// System.out.println("58 "+c.getCurl().toString());
		try{
			os = c.getoutput();
			os.write(q.getToQuery().getBytes("UTF-8"));
			os.flush();
			try {
                is = c.getInputStream();
				if(is == null){
					System.out.println("is null");
				}
				else{
					System.out.println("is not null");
				}
				System.out.println("String : "+is.toString());
				System.out.println("class : "+is.getClass());
                // convert inputstream to string
                if(is != null){
                    result = convertStreamToString(is);
				}
                else{
                    result = "Did not work!";
				}
            }
            catch (Exception e) {
				System.out.print("app.java 75 : ");
                e.printStackTrace();
            }
			finally {
                c.getCurl().disconnect();
            }
		}
		catch(Exception e){
			System.out.print("app.java 84 : ");
			// System.out.println(e);
			e.printStackTrace();
		}
		System.out.println(result);
    }
}
