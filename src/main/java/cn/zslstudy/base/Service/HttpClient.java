package cn.zslstudy.base.Service;

import com.dtflys.forest.annotation.DataVariable;
import com.dtflys.forest.annotation.Request;
import org.springframework.stereotype.Component;

@Component
public interface HttpClient {
    @Request(
            url = "${url}",
            sslProtocol = "SSL",
            type = "GET"
    )
    String get(@DataVariable("url") String url);
}
