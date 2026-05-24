-- 사용자 데이터
INSERT IGNORE INTO users (user_id, name, handle, bio, profile_image_url, created_at)
VALUES (1, '이현경', 'efub6_backend1', '이펍 6기 백엔드 인턴입니다!', null, NOW());

INSERT IGNORE INTO users (user_id, name, handle, bio, profile_image_url, created_at)
VALUES (2, '마승혜', 'efub6_frontend1', '이펍 6기 프론트 인턴입니다!', null, NOW());