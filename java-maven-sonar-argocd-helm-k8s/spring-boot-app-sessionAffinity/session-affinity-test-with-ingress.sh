#!/bin/bash

# Define the service URL
SERVICE_URL="http://spring-boot-app.local"  # Using Ingress host instead of ClusterIP

echo "Testing session affinity for $SERVICE_URL"
echo "----------------------------------------"

# Run multiple requests with session persistence
for i in {1..10}; do
    RESPONSE=$(curl -s -b cookie.txt -c cookie.txt -w "\nNode IP: %{remote_ip}" "$SERVICE_URL")

    # Extract a unique identifier from the response (e.g., pod name or hostname)
    POD_IDENTIFIER=$(echo "$RESPONSE" | grep -oP '(?<=<h1>).*(?=</h1>)')
    NODE_IP=$(echo "$RESPONSE" | grep -oP '(?<=Node IP: ).*')

    # Print the response
    if [ -n "$POD_IDENTIFIER" ] && [ -n "$NODE_IP" ]; then
        echo "Request $i -> Pod: $POD_IDENTIFIER | Node: $NODE_IP"
    else
        echo "Request $i -> No valid response or missing session info"
    fi
done

echo "----------------------------------------"
