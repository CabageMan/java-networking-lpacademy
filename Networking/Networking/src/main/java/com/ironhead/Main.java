package com.ironhead;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

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
      URL url = new URL("http://example.org");

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
      URLConnection urlConnection = url.openConnection();
      urlConnection.setDoOutput(true);
      urlConnection.connect();

      BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
      String line = "";
      while (line != null) {
        line = inputStream.readLine();
        System.out.println(line);
      }
      inputStream.close();

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