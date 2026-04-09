# Bai 2 - Phan tich luong Input/Output voi Thymeleaf

## 1. Cau truc doi tuong `Dish`

`Dish` duoc dat trong package `org.example.ex_02.common` de tai su dung cho cac bai sau.

| Thuoc tinh | Kieu du lieu | Y nghia |
|---|---|---|
| `id` | `Long` | Ma dinh danh mon an |
| `name` | `String` | Ten mon an |
| `price` | `double` | Gia mon an |
| `isAvailable` | `boolean` | Trang thai ton kho (`true`: con hang, `false`: het hang) |

## 2. So do luong Input -> Output

```text
Client (Browser)
    |
    | GET /bai2/dishes
    v
DishController (package bai2.controller)
    |
    | goi DishService.getAllDishes()
    v
DishServiceImpl (package bai2.service)
    |
    | tra ve List<Dish>
    v
Model
    |- dishes: List<Dish>
    |- hasDishes: boolean
    v
Thymeleaf View: dish-list.html
    |- th:unless="${hasDishes}" -> hien thong bao cap nhat thuc don
    |- th:if="${hasDishes}" + th:each -> lap tung mon
    |- th:if/th:unless theo dish.available -> "Con hang" / "Het hang"
    |- class out-of-stock -> mau do cho mon het hang
    v
HTML tra ve cho trinh duyet
```

## 3. Cac bieu thuc Standard Dialect da dung

- `th:if` / `th:unless`: dieu kien hien thi block va trang thai.
- `th:each`: lap danh sach `dishes`.
- `th:text`: bind du lieu tu `Model` ra giao dien.
- `#numbers.formatDecimal(...)`: dinh dang gia tien de de doc hon.

## 4. Xu ly bay du lieu (null/empty)

Controller dat bien `hasDishes = dishes != null && !dishes.isEmpty()`.

- Neu `hasDishes = false`: view hien thong diep
  > Hiện tại nhà hàng đang cập nhật thực đơn, vui lòng quay lại sau
- Neu `hasDishes = true`: view hien bang thuc don.

