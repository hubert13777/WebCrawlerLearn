package test;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.Closeable;
import java.io.IOException;

/**
 * 获取整个静态网页的demo
 */
public class Crawler01 {
    public static void main(String[] args) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //发送请求,接收响应
        HttpGet get = new HttpGet("http://news.inewsweek.cn/cover/");
        try {
            CloseableHttpResponse response = httpClient.execute(get); //响应结果
            //解析响应,获取数据
            if(response.getStatusLine().getStatusCode()==200){
                HttpEntity httpEntity=response.getEntity();
                String content= EntityUtils.toString(httpEntity,"gbk");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
