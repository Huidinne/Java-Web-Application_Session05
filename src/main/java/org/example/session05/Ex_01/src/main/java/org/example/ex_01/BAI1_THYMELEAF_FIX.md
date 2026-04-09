## 1) Các điểm sai trong cấu hình cũ
Đoạn cấu hình giả lập bị sai ở ít nhất 2 điểm sau:

1. `prefix` dùng đường dẫn JSP (hoặc thiếu dấu `/` cuối) thay vì thư mục template Thymeleaf.
   - Sai: `resolver.setPrefix("/WEB-INF/views")`
   - Đúng cho bài này: `resolver.setPrefix("/WEB-INF/templates/")`

2. `suffix` để `.jsp` trong khi Thymeleaf cần map view sang file HTML.
   - Sai: `resolver.setSuffix(".jsp")`
   - Đúng: `resolver.setSuffix(".html")`

## 2) Đã sửa trong source
- Đã chuyển `WebConfig.java` sang package `com.restaurant.bai1` theo yêu cầu.
- Đã sửa `SpringResourceTemplateResolver`:
  - `prefix = /WEB-INF/templates/`
  - `suffix = .html`
  - giữ `TemplateMode.HTML` và `UTF-8`.
- Đã cập nhật `WebInit.java` để nạp `com.restaurant.bai1.WebConfig`.

## 3) Kết quả mong đợi
Khi controller trả về view name ví dụ `"home"`, hệ thống sẽ resolve đến:

`/WEB-INF/templates/home.html`

thay vì tìm file JSP.
