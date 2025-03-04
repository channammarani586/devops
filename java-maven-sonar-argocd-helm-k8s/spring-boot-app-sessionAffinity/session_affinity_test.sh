#!/bin/bash

# Define the service URL
SERVICE_URL="http://10.43.21.67"  # Replace with your service URL

echo "Testing session affinity for $SERVICE_URL"
echo "----------------------------------------"

# Run multiple requests
for i in {1..10}; do
    RESPONSE=$(curl -s $SERVICE_URL)

    # Extract any unique identifier from the HTML response (hostname or IP)
    POD_IDENTIFIER=$(echo "$RESPONSE" | grep -oP '(?<=<h1>).*(?=</h1>)')

    # Print the response
    if [ -n "$POD_IDENTIFIER" ]; then
        echo "Request $i -> Response Identifier: $POD_IDENTIFIER"
    else
        echo "Request $i -> No valid response"
    fi
done

echo "----------------------------------------"
