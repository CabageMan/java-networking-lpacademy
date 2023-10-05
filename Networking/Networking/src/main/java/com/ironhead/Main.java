package com.ironhead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {
  public static void main(String[] args) {
    /*
    try {
      // Path to resource (db:). This cause an URL malformed exception.
      URI uri = new URI("db://userName:password@myserver.com:5000/catalogue/phones?os=android#samsung");
//      URI uri = new URI("wrongURIExample");
      System.out.println("Scheme: " + uri.getScheme());
      System.out.println("Scheme-specific: " + uri.getSchemeSpecificPart());
      System.out.println("Autority: " + uri.getAuthority());
      System.out.println("User info: " + uri.getUserInfo());
      System.out.println("Host: " + uri.getHost());
      System.out.println("Port: " + uri.getPort());
      System.out.println("Path: " + uri.getPath());
      System.out.println("Query: " + uri.getQuery());
      System.out.println("Fragment: " + uri.getFragment());

      URI baseUri = new URI("http://userName:password@myserver.com:5000");
      URI uriPhone = new URI("/catalogue/phones?os=android#samsung");
      URI uriTV = new URI("/catalogue/tvs?manufacturer=samsung");
      URI uriStoresLocations = new URI("/stores/locations?zip=12345");
      URI resolvedUriPhones = baseUri.resolve(uriPhone);
      URI resolvedUriTVs = baseUri.resolve(uriTV);
      URI resolvedUriStoresLocations = baseUri.resolve(uriStoresLocations);

      URL urlPhones = resolvedUriPhones.toURL();
      URL urlTVs = resolvedUriTVs.toURL();
      URL urlStores = resolvedUriStoresLocations.toURL();
      System.out.println("Phones URL: " + urlPhones);
      System.out.println("TVs URL: " + urlTVs);
      System.out.println("Stores URL: " + urlStores);

      URI relativisedURI = baseUri.relativize(resolvedUriPhones);
      System.out.println("Relative URI: " + relativisedURI);
    } catch (URISyntaxException e) {
      System.out.println("URI bad syntax: " + e.getMessage());
    } catch (MalformedURLException e) {
      System.out.println("URL Malformed: " + e.getMessage());
    }
     */

    try {
//      URL url = new URL("http://example.org");
      URL url = new URL("https://api.flickr.com/services/feeds/photos_public.gne?tags=cats");

      // Checking URI
      /*
      URI uri = url.toURI();
      System.out.println("Scheme: " + uri.getScheme());
      System.out.println("Scheme-specific: " + uri.getSchemeSpecificPart());
      System.out.println("Autority: " + uri.getAuthority());
      System.out.println("User info: " + uri.getUserInfo());
      System.out.println("Host: " + uri.getHost());
      System.out.println("Port: " + uri.getPort());
      System.out.println("Path: " + uri.getPath());
      System.out.println("Query: " + uri.getQuery());
      System.out.println("Fragment: " + uri.getFragment());
       */

      // Get data from url
      /*
      BufferedReader inputStream = new BufferedReader(new InputStreamReader(url.openStream()));
      String line = "";
      while (line != null) {
        line = inputStream.readLine();
        System.out.println(line);
      }
      inputStream.close();
       */

      // URL Connection
      /*
      URLConnection urlConnection = url.openConnection();
      urlConnection.setDoOutput(true);
      urlConnection.connect();

      BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
      for (Map.Entry<String, List<String>> entry : headerFields.entrySet()) {
        String key = entry.getKey();
        List<String> value = entry.getValue();
        System.out.println("-Key: " + key);
        for (String string : value) {
          System.out.println("---Value: " + value);
        }
      }
//      String line = "";
//      while (line != null) {
//        line = inputStream.readLine();
//        System.out.println(line);
//      }
//      inputStream.close();
       */

      // HTTP URL Connection
      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("User-Agent", "Chrome");
      connection.setReadTimeout(30000);

      int responseCode = connection.getResponseCode(); // .getResponseCode() implicity calls the .connect() method under the hood.
      System.out.println("Response code: " + responseCode);

      if (responseCode != 200) {
        System.out.println("Error reading web page: \n" + connection.getResponseMessage());
        return;
      }

      BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      while ((line = inputReader.readLine()) != null) {
        System.out.println(line);
      }
      inputReader.close();

      // Checking URI
      /*
    } catch (URISyntaxException e) {
      System.out.println("URI bad syntax: " + e.getMessage());
     */
    } catch (MalformedURLException e) {
      System.out.println("URL Malformed: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IOException: " + e.getMessage());
    }
  }
}