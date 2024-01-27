<h3>ĐỀ TÀI : XÂY DỰNG CHƯƠNG TRÌNH CHAT</h3>
    <h4>Yêu cầu về chức năng phía client (phải có GUI):</h4>
    <ul>
        <li>Đăng ký tài khoản mới, đăng nhập, cập nhật thông tin tài khoản. Thông tin tối thiểu cho mỗi
            tài khoản gồm có các trường: username (chính là địa chỉ email), password (hash), họ tên, giới
            tính, ngày sinh. Ngoài ra, địa chỉ email lúc đăng ký phải được xác thực bằng OTP (timeout 10
            phút) trước khi tài khoản đó được kích hoạt</li>
        <li>Tạo nhóm chat mới hoặc gia nhập/rời khỏi các nhóm chat có sẵn</li>
        <li>Gửi tin nhắn 1-1 hoặc 1-nhóm</li>
        <li>Gửi file đính kèm (dung lượng dưới 1MB), gửi sticker</li>
        <li>Chặn nhận tin nhắn từ 1 người dùng hoặc 1 nhóm</li>
        <li>Xác nhận tin nhắn đã gửi/nhận, đã xem</li>
        <li>Friend list: lưu giữ danh sách và cho biết trạng thái (online hoặc offline) của những người mà user
            đã từng chat, có thông báo khi bất cứ user nào trong friend list thay đổi trạng thái</li>
        <li>Chức năng quản lý và lưu giữ tin nhắn: toàn bộ tin nhắn của người dùng được lưu trữ trên
            server, khi client đăng nhập, những tin nhắn gần đây nhất sẽ được đẩy về giao diện phía client</li>
    </ul>

<h4>Yêu cầu về chức năng phía server:</h4>
    <ul>
        <li>Thống kê được tổng số user, các user đang online</li>
        <li>Ghi log khi user login/logout hoặc thực hiện các chức năng: đăng ký tài khoản; tạo nhóm</li>
        <li>Block user bằng lệnh (hoặc giao diện đồ họa)</li>
        <li>Broadcast tin nhắn từ hệ thống đến toàn bộ user</li>
    </ul>

<h4>Yêu cầu chung:</h4>
    <ul>
        <li>Mã hóa nội dung tin nhắn giữa client – server. Phải sử dụng key khác nhau cho các client => Sử dụng RSA và AES</li>
    </ul>

<h4>Yêu cầu phải có:</h4>
    <ul>
            <li>Jdk 1.8</li>
            <li>Mysql</li>
        </ul>

<h4>Cách chạy chương trình</h4>
    <ol>
        <li>Clone source code về và giải nén thư mục `Library.zip` sau đó import các thư viện trong thư mục</li>
        <li>Tạo CSDL với tên `chatdb` và import file chatdb.sql</li>
        <li>Khởi chạy server src/Network/ServerGUI.java</li>
        <li>Chạy các client src/GUI/Login.java để bắt đầu</li>
    </ol>
