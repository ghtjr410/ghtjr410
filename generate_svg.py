# import json

# # 독서 기록 데이터 (JSON에서 불러올 수도 있음)
# books = [
#     {"title": "클린 코드", "start": 1, "end": 3, "color": "blue"},
#     {"title": "리팩터링", "start": 2, "end": 5, "color": "green"},
#     {"title": "이펙티브 자바", "start": 4, "end": 7, "color": "orange"}
# ]

# # SVG 기본 설정
# svg_header = '<svg width="800" height="200" xmlns="http://www.w3.org/2000/svg">\n'
# svg_footer = "</svg>"

# svg_body = ""

# # X축 (월 표시)
# for i in range(1, 13):
#     x_pos = i * 60
#     svg_body += f'<text x="{x_pos}" y="40" font-size="12" fill="black">{i}월</text>\n'

# # Gantt Chart 스타일 막대 생성
# y_position = 50
# for book in books:
#     x_start = book["start"] * 60
#     width = (book["end"] - book["start"]) * 60
#     svg_body += f'<rect x="{x_start}" y="{y_position}" width="{width}" height="20" fill="{book["color"]}" rx="5" ry="5"/>\n'
#     svg_body += f'<text x="{x_start + width + 5}" y="{y_position + 15}" font-size="12" fill="black">{book["title"]}</text>\n'
#     y_position += 40

# # 최종 SVG 파일 생성
# svg_content = svg_header + svg_body + svg_footer

# # SVG 저장
# with open("reading_timeline.svg", "w", encoding="utf-8") as f:
#     f.write(svg_content)

# print("✅ SVG 파일이 생성되었습니다! (reading_timeline.svg)")

import json
import math

# 카테고리별 독서 통계 데이터
categories = {
    "CS": 5,
    "Language": 3,
    "Framework": 2,
    "Database": 4,
    "Infra": 3
}

# SVG 기본 설정
svg_width = 400
svg_height = 300
center_x = svg_width // 2
center_y = svg_height // 2
radius = 80

colors = ["#FF6384", "#36A2EB", "#FFCE56", "#4BC0C0", "#9966FF"]
category_labels = list(categories.keys())
values = list(categories.values())

total = sum(values)
angles = [v / total * 360 for v in values]

# SVG 시작
svg_content = f'<svg width="{svg_width}" height="{svg_height}" xmlns="http://www.w3.org/2000/svg">\n'
svg_content += '<rect width="100%" height="100%" fill="#1E1E2E" rx="10"/>\n'  # 다크 테마 배경

# 원형 그래프 (Pie Chart) 그리기
start_angle = 0
for i, angle in enumerate(angles):
    end_angle = start_angle + angle
    large_arc = 1 if angle > 180 else 0
    x1 = center_x + radius * round(math.cos(math.radians(start_angle)), 2)
    y1 = center_y - radius * round(math.sin(math.radians(start_angle)), 2)
    x2 = center_x + radius * round(math.cos(math.radians(end_angle)), 2)
    y2 = center_y - radius * round(math.sin(math.radians(end_angle)), 2)

    path = f'M {center_x},{center_y} L {x1},{y1} A {radius},{radius} 0 {large_arc},1 {x2},{y2} Z'
    svg_content += f'<path d="{path}" fill="{colors[i]}" stroke="black" stroke-width="1"/>\n'
    start_angle = end_angle

# 범례 (Legend) 추가
legend_x = 20
legend_y = 230
for i, category in enumerate(category_labels):
    svg_content += f'<rect x="{legend_x}" y="{legend_y}" width="15" height="15" fill="{colors[i]}" rx="3"/>\n'
    svg_content += f'<text x="{legend_x + 20}" y="{legend_y + 12}" font-size="14" fill="white">{category} ({values[i]}권)</text>\n'
    legend_y += 25

# SVG 종료
svg_content += "</svg>"

# SVG 저장
with open("reading_stats.svg", "w", encoding="utf-8") as f:
    f.write(svg_content)

print("✅ SVG 파일이 생성되었습니다! (reading_stats.svg)")