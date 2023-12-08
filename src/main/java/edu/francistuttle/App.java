package edu.francistuttle;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndContentImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.feed.synd.SyndLinkImpl;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.net.URL;
import java.util.List;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {/*ww w  . j a va  2 s . c om*/
            String urlString = "https://www.nasa.gov/news-release/feed/";
            URL feedUrl = new URL(urlString);

            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedUrl));

            System.out.println("Feed Title: " + feed.getTitle());
            System.out.println("Feed Description: " + feed.getDescription());
            System.out.println("Feed Link: " + feed.getLink());

            for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()) {
                System.out.println("Title: " + entry.getTitle());
                System.out.println("Unique Identifier: " + entry.getUri());
                System.out.println("Published Date: " + entry.getPublishedDate());
            }
        }
        catch (Exception ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
}
