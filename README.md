# Phiên bản Demo hoạt động của mạng lưới Blockchain
<h1> 1. Nội dung demo </h1>
Chương trình này sẽ demo một số hoạt động cơ bản của blockchain như sau: tạo giao dịch, tạo khối, tạo bằng chứng xử lý (xác thực block) và thêm block vào chain. Chương trình được viết thuần hướng đối tượng bằng Java, do đó mỗi chức năng sẽ do một class đảm nhận riêng biệt. Toàn bộ demo sẽ thực hiện trên màn hình console, không có GUI và DB.

Blockchain có thể được xem như là một danh sách liên kết như hình bên dưới:

![Block](https://user-images.githubusercontent.com/43202025/58762419-16691300-857a-11e9-8b9f-418d910f61b3.png)

<h1> 2. Cấu trúc project </h1>
<ul>
<li>class Block: chức thông tin thiết yếu của một block, bao gồm index, hash, pre_hash, nonce parameter và data. Những trường khác có lẽ cũng quan trọng không kém là hash of Merkle tree, timestamps, ... nhưng không đưa vào vì nó không liên quan gì đến nội dung đã nói trên. class block sẽ có những phương thức như constructor() và print().</li>
<li>class SHA-256: getHash() của một block, data của block đưa vào với bất kì nội dung nào, độ dài nào thì đều xuất ra kết quả là một chuỗi 256 bit - 64 kí tự HEX hoàn toàn ngẫu nhiên, vì có đến 2^256 kết quả hash nên nó vẫn có thể đảm bảo tính unique</li>
<li>class miner: có nhiệm vụ tìm tham số nonce, sao cho khi getHash(block + nonce) thì phải ra được chuỗi hash có n số 0 phía trước. Vì nonce không có quy luật nên miner thường phải thử từ 0 -> 2^32, sau đó đảo data lại rồi lại lặp từ 0. </li>
  
Tóm tắt lại bằng class Diagram và Sequency Diagram phía dưới.

![ClassDiagram](https://user-images.githubusercontent.com/43202025/58762577-61375a80-857b-11e9-88f3-e5caf3dd283d.png)

![SequenceDiagram](https://user-images.githubusercontent.com/43202025/58762622-c3905b00-857b-11e9-9037-93f1cbdb9a6a.png)


<h1> 3. Một vài lưu ý </h1>

Điểm trọng tâm của blockchain có lẽ là câu chuyện sync & cơ chế đồng thuận mạng lưới, tuy nhiên phần code đó hơi phức tạp nên trong class chỉ tạo một đối tượng chain, miner và user (người dùng) tương tác với nhau.

Source code được viết trên IDE Eclipse, nếu không muốn tải Eclipse về thì bạn có thể copy các file class rồi chạy trên IDE/ Editor nào đó hỗ trợ Java là được, ví dụ như VS code, Netbeans.
