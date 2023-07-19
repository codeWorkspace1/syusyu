package com.teamProject.syusyu.controller.product;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.product.ImageDTO;
import com.teamProject.syusyu.domain.product.ProductDTO;
import com.teamProject.syusyu.service.product.CategoryService;
import com.teamProject.syusyu.service.product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class ProductController {

    @Autowired
    CategoryService categoryService;
    @Autowired
    ProductService productService;


    /**
     * 이 메소드는 모든 카테고리를 가져와서 세션에 저장하는 기능을 수행합니다.
     * HTTP GET 요청을 통해 호출되며, 반환 값은 모든 카테고리의 정보와 HTTP 상태 코드입니다.
     *
     * @param request HttpServletRequest 객체. 세션을 얻기 위해 사용됩니다.
     * @return categories가 null이면 HTTP 상태 코드 204(NO CONTENT)와 함께 null 반환, 그렇지 않으면 categories 객체와 HTTP 상태 코드 200(OK)를 ResponseEntity 객체로 반환.
     * @throws Exception 카테고리 서비스에서 카테고리 목록을 가져오는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/06
     */
    @GetMapping("/categories")
    public ResponseEntity<Map<String, Object>> CategoryAllList(HttpServletRequest request) {
        try {
            Map<String, Object> categories = categoryService.getCategoryAllList();

            if (categories == null) {
                System.out.println("categories is null");
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }


            // 세션에 카테고리 저장
            HttpSession session = request.getSession();
            session.setAttribute("categories", categories);

            return new ResponseEntity<>(categories, HttpStatus.OK);
        } catch (Exception e) {
            // 예외 처리 로직 추가
            System.out.println("An error occurred: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/productList")
    public String ProductLargeView() {

        return ViewPath.FOS_PRODUCT + "productList";
    }

    /**
     * 상품 목록 뷰를 반환하는 메소드입니다.
     * 이 메소드는 상품 목록 페이지를 보여주는 역할을 담당합니다.
     *
     * @return 상품 목록 뷰의 경로를 나타내는 문자열을 반환합니다. 이 문자열은 ViewPath 클래스의 FOS_PRODUCT 상수와 "productList" 문자열을 합쳐서 생성됩니다.
     * @author soso
     * @since 2023/07/06
     */
    @GetMapping("/productList/{middleNo}/{smallNo}")
    public String ProductListView(@PathVariable("middleNo") Integer middleNo,
                                  @PathVariable("smallNo") Integer smallNo,
                                  Model model) {
        model.addAttribute("middleNo", middleNo);
        model.addAttribute("smallNo", smallNo);
        return ViewPath.FOS_PRODUCT + "productList";
    }


    /**
     * 주어진 중분류 및 소분류 번호를 사용하여 해당 카테고리에 속한 상품 목록을 가져오는 메소드입니다.
     * 이 메소드는 HTTP GET 요청을 통해 호출되며, 반환 값은 JSON 형식의 상품 목록과 총 상품 갯수입니다.
     *
     * @param middleNo 카테고리 중분류 번호. 이 값이 null인 경우, 디폴트 값으로 1이 사용됩니다.
     * @param smallNo  카테고리 소분류 번호. 이 값이 null인 경우, 디폴트 값으로 1이 사용됩니다.
     * @return 해당 중분류와 소분류 번호에 속한 상품 목록과 총 상품 갯수를 담은 Map을 ResponseEntity 객체로 반환합니다.
     * 성공적인 경우 HTTP 상태 코드 200 (OK)와 상품 정보를 담은 Map을, 그렇지 않은 경우 400 (Bad Request)와 null을 반환합니다.
     * @throws Exception 상품 서비스에서 상품 목록을 가져오는 도중 발생할 수 있는 예외
     * @author soso
     * @since 2023/07/07
     */
    @GetMapping("/productListData/{middleNo}/{smallNo}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getProductList(@PathVariable Integer middleNo, @PathVariable Integer smallNo) {
        Map<String, Object> productInfo = null;
        System.out.println("middleNo" + middleNo);
        System.out.println("smallNo" + smallNo);
        try {
            if (middleNo == null || smallNo == null) {
                middleNo = 1;
                smallNo = 1;
            }
            productInfo = productService.getProductList(middleNo, smallNo);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(productInfo, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productInfo, HttpStatus.OK);
    }

    /**
     * 중분류 번호를 사용하여 해당 카테고리에 속한 모든 상품 목록을 보여주는 메소드입니다.
     * 이 메소드는 HTTP GET 요청을 통해 호출되며, 상품 목록을 보여주는 뷰 경로를 반환합니다.
     *
     * @param middleNo 카테고리 중분류 번호
     * @return 상품 목록을 보여주는 뷰 경로
     * @author soso
     * @since 2023/07/10
     */
    @GetMapping("/productList/{middleNo}")
    public String getProductAllList(@PathVariable("middleNo") Integer middleNo, Model model) {
        model.addAttribute("middleNo", middleNo);
        return ViewPath.FOS_PRODUCT + "productList";
    }

    /**
     * 중분류 번호를 사용하여 해당 카테고리에 속한 모든 상품 목록을 보여주는 메소드입니다.
     * 이 메소드는 HTTP GET 요청을 통해 호출되며, 상품 목록을 보여주는 뷰 경로를 반환합니다.
     *
     * @param middleNo 카테고리 중분류 번호
     * @return 상품 목록을 보여주는 뷰 경로
     * @author soso
     * @since 2023/07/08
     */
    @GetMapping("/productListData/{middleNo}")
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getProductAllList(@PathVariable Integer middleNo) {
        Map<String, Object> productInfo = null;

        if (middleNo == null || middleNo == 0) {
            middleNo = 1;
        }
        try {

            //중분류 카테고리별 전체 상품리스트와 전체 갯수, 카테고리를 map으로 보냄
            productInfo = productService.getProductAllList(middleNo);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(productInfo, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productInfo, HttpStatus.OK);
    }


    @GetMapping("productStatus")
    @ResponseBody
    public ResponseEntity<List<ProductDTO>> getProductStatus(int[] prodIdArr) {
        List<ProductDTO> productStatusList = null;

        try {
            productStatusList = productService.getProductStatus(prodIdArr);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(productStatusList, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(productStatusList, HttpStatus.OK);
    }


    @GetMapping("/product/{prodId}")
    public String getProduct(@PathVariable int prodId, Model m) {
        Map<String, Object> productDetail = null;
        ProductDTO product = null;
        List<ImageDTO> imageList = null;
        try {
            System.out.println("prodId = " + prodId);
            productDetail = productService.getProduct(prodId);

            product = (ProductDTO) productDetail.get("productDetail");
            m.addAttribute("productDetail", product);
            System.out.println("Product:" + product);
            imageList = (List<ImageDTO>) productDetail.get("imageList");
            m.addAttribute("imageList", imageList);
            System.out.println("Image : " + imageList);


        } catch (Exception e) {
            e.printStackTrace();
        }
        return ViewPath.FOS_PRODUCT + "product";
    }
}
