package com.psl.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.*;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.Source;
import net.htmlparser.jericho.TextExtractor;

@SuppressWarnings("serial")
public class DictionaryServlet extends HttpServlet {
                
                String searchWord = "";
                String txtWebResponse = "";
                
                public void doGet(HttpServletRequest req, HttpServletResponse resp)
                                                throws IOException {
                                
                                String searchWord= req.getParameter("txtweb-message");
                                System.out.println("Serache string ::" + searchWord);
                                if (searchWord ==null)
                                                sendResponse(resp,"Welcome to Dictionary on txtWeb<br/>Reply with @word1234 (word)");
                                else
                                                findMeaning(resp,searchWord);
                }

                private void sendResponse(HttpServletResponse resp, String smsResponse) {
                                try {
                                                PrintWriter out = resp.getWriter();
                                                /*out.println("<html><head><meta name=\"txtweb-appkey\" content=\"3a7f260b-b1d8-4fc4-86ed-420209b63d85\" /></head><body>"
                                                                                +smsResponse 
                                                                                +"</body></html>"); */
                                                out.println("The meaning of the word  '" + searchWord + "' :: " + smsResponse);
                                } catch (IOException e) {
                                                
                                                e.printStackTrace();
                                }
                                
                }

                private void findMeaning(HttpServletResponse resp,String word) throws MalformedURLException, IOException {
                                
                                
                                searchWord = URLEncoder.encode(word, "UTF-8");
                                String sourceUrlString="http://en.wiktionary.org/wiki/" + searchWord;
                                Source source=new Source(new URL(sourceUrlString));
                                Element bodyContent = source.getElementById("bodyContent");
                                txtWebResponse = parseHtmlNode(bodyContent);
                                if(!txtWebResponse.isEmpty())
                                                sendResponse(resp,"The meaning for the word : "+word+" is -"+txtWebResponse);
                                else
                                                sendResponse(resp,"Nothing Found for the word "+word);
                }
                                

                private String parseHtmlNode(Element theElement) {
                                
                                List<Element> children = (List<Element>)theElement.getChildElements();
                                txtWebResponse = "";
                                outer : for (Element child: children) 
                                {
                                                if (child.getName().equals("ol"))
                                                {
                                                                List<Element> multipleAnswersChildren = (List<Element>)child.getChildElements();
                                                                txtWebResponse += (new TextExtractor(multipleAnswersChildren.get(0).getContent())).toString()+" ";
                                                                break outer;
                                                }
                                }
                                return txtWebResponse;
                }
                                
}
