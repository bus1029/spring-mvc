package hello.springmvc.basic.request

import org.slf4j.LoggerFactory
import org.springframework.http.HttpMethod
import org.springframework.util.MultiValueMap
import org.springframework.web.bind.annotation.CookieValue
import org.springframework.web.bind.annotation.RequestHeader
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@RestController
class RequestHeaderController {
  private val logger = LoggerFactory.getLogger(javaClass)

  @RequestMapping("/headers")
  fun headers(request: HttpServletRequest?,
              response: HttpServletResponse?,
              httpMethod: HttpMethod,
              locale: Locale,
              @RequestHeader headerMap: MultiValueMap<String, String>,
              @RequestHeader("host") host: String,
              @CookieValue(value = "myCookie", required = false) cookie: String?): String {

    logger.info("request={}", request);
    logger.info("response={}", response);
    logger.info("httpMethod={}", httpMethod);
    logger.info("locale={}", locale);
    logger.info("headerMap={}", headerMap);
    logger.info("header host={}", host);
    logger.info("myCookie={}", cookie);
    return "ok";
  }
}