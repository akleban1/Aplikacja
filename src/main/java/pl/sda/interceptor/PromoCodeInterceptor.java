package pl.sda.interceptor;

import lombok.Data;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Data
public class PromoCodeInterceptor extends HandlerInterceptorAdapter {
    private String promoCode;
    private String errorRedirect;
    private String offerRedirect;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String givenPromoCode = request.getParameterValues("promo") == null ? "" : request.getParameterValues("promo")[0];
        if (request.getRequestURI().endsWith("products/specialOffer")) {
            if (givenPromoCode.equals(promoCode)) {
                response.sendRedirect(request.getContextPath() + "/" + offerRedirect);
            } else {
                response.sendRedirect(errorRedirect);
            }
            return false;
        }
        return true;
    }
}


